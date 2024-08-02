package oa.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC的工具类
 */
public class DBUtil {

    //静态变量，在类加载时执行，并且有顺序（自上而下的顺序）
    //属性资源绑定
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");

    //根据属性配置文件的key获取value
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");


    static{
        //注册驱动（注册驱动只需要注册一次，放在静态代码块中，类加载的时候执行）
        try {
            //com.mysql.jdbc.Driver是连接数据库的驱动，不能写死，可能会连接oracle数据库
            //如果连接Oracle数据库的时候，需要修改java代码，显然违背了OCP原则
            //OCP开闭原则，多扩展开放，对修改关闭（什么符合OCP原则呢？在进行功能扩建的时候，不需要修改java源代码）
            //Class.forName("com.mysql.jdbc.Driver");
             Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取与数据库的连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        //获取连接
        Connection conn = DriverManager.getConnection(url,user,password);

        return conn;
    }

    /**
     *  关闭相应流通道
     * @param conn 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集对象
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
