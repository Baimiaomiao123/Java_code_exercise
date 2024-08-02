package oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oa.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决请求体的中文乱码问题
        request.setCharacterEncoding("UTF-8");

        //获取表单中的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        //连接数据库更新数据
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "update dept set dname = ?,loc = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }

        if (count==1) {
            //更新成功
            //转发(由于转发的是doPost方法，下一个java程序中也要有重写doPost方法，否则就会调用父类的doPost方法报405错误)
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            //重定向
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }else{
            //更新失败
            response.sendRedirect(request.getContextPath() + "/html/error.html");
        }
    }
}
