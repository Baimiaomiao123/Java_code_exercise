package Simulation;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        System.out.println("启动了service服务");
        //设置响应的内容类型
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        //连接数据库（JDBC）
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "mp102030..";

            conn = DriverManager.getConnection(url,user,password);

            //获取预编译的数据库操作对象
            String sql = "select no,name from students;";
            ps = conn.prepareStatement(sql);

            //执行sql
            rs = ps.executeQuery();

            //处理结果集
            while(rs.next()){
                String no = rs.getString("no");
                String name = rs.getString("name");
                out.print(no + " , " + name + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
