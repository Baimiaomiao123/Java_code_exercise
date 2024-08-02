package oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oa.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取应用的根路径
        String contextPath = request.getContextPath();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>修改部门</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("  <h1>修改部门</h1>");
        out.print("  <hr>");
        out.print("  <form action='" + contextPath + "/dept/update' method='Post'>");

        //获取部门编号
        String deptno = request.getParameter("deptno");

        //连接数据库查询部门的信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select dname, loc as location from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs = ps.executeQuery();
            //这个结果集只有1条记录
            if(rs.next()){
                String dname = rs.getString("dname");
                String location = rs.getString("location");

                //输出动态网页
                out.print("  部门编号<input type='text' name='deptno' value='" + deptno + "' readonly /><br>");
                out.print("  部门名称<input type='text' name='dname' value='" + dname + "'/><br>");
                out.print("  部门位置<input type='text' name='loc' value='" + location + "'/><br>");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }

        out.print(" <input type='submit' value='修改'/>");
        out.print("  </form>");
        out.print("</body>");
        out.print("</html>");

    }
}
