package oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import oa.util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取Cookie数组
        //这个Cookie[]数组可能是null，如果不是null，数组的长度一定是大于0的
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;

        //首先验证有没有cookie
        if (cookies != null) {
            for (Cookie cookie:
                 cookies) {
                String name = cookie.getName();
                if ("username".equals(name)){
                    username = cookie.getValue();
                }else if ("password".equals(name)){
                    password = cookie.getValue();
                }
            }
        }

        //如果有cookie，则验证cookie中的用户名和密码是否与数据库中的用户名和密码是否相同
        //要在这里使用username和password
        if(username != null && password != null){
            //验证用户名和密码是否正确
            //正确，表示登陆成功：跳转到部门列表页面
            //错误，表示登陆失败：跳转到登陆页面
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            boolean success = false;
            try {
                conn = DBUtil.getConnection();
                String sql = "select * from t_user where username = ? and  password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                if (rs.next()){
                    //登陆成功
                    success = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(conn,ps,rs);
            }

            if (success){
                //登陆成功
                //获取session
                HttpSession session = request.getSession();
                session.setAttribute("username",username);

                response.sendRedirect( request.getContextPath() + "/dept/list");
            }else {
                //登陆失败，直接跳转到登陆页面
                response.sendRedirect( request.getContextPath() + "/index.jsp");
            }

        }else {
            //跳转到登陆页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
