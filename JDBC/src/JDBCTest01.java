import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    JDBC编程六步
 */
public class JDBCTest01 {
    public static void main(String[] args) {

        try {
            //1、注册驱动
            Driver driver = new com.mysql.jdbc.Driver(); //driver是一个接口，com.mysql.jdbc.Driver是一个实现类
            DriverManager.registerDriver(driver);

            //2、获取连接
            String url = " ";
            String user = "root";
            String password = " ";
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接对象 = " + conn);

            //3、
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
