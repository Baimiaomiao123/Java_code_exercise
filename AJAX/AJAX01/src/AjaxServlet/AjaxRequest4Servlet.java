package AjaxServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/request4")
public class AjaxRequest4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户名
        String username = request.getParameter("username");
        //打布尔标记（一种编程模型）
        boolean flag = false; //默认是用户名不存在

        //连接数据库验证用户名是否存在
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mp102030..");
            //获取预编译的数据库操作对象
            String sql = "select username from t_user where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            //执行sql语句
            rs =ps.executeQuery();
            //处理结果集
            if(rs.next()){
                flag = true; //表示用户存在
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //响应结果到浏览器
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(flag){
            //用户名存在
            out.print("<font color='red'>对不起，用户名已存在</font>");
        }else{
            //用户名不存在
            out.print("<font color='green'>用户名可用</font>");
        }
    }
}
