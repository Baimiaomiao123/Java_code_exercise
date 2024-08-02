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

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*根据部门编号删除部分*/
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取部门编号
        String deptno = request.getParameter("deptno");
        //连接数据库，删除数据
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            //开启事务(自动提交机制关闭)
            conn.setAutoCommit(false);
            String sql = "delete from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            //返回值是影响了数据库表当中给的多少条记录
            count = ps.executeUpdate();
            //事务提交
            conn.commit();

        } catch (SQLException e) {

            //遇到异常要回滚
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }

        //判断删除成功还是失败
        if(count == 1){
            //删除成熟
            out.print("window.alert('删除成功！')");
            //仍然跳转到部门列表页面
            //部门列表页面的现实需要执行另一个Servlet，怎么办？转发
            request.getRequestDispatcher("/dept/list").forward(request,response);
        }else {
            //删除失败
            out.print("window.alert('删除失败！')");
            request.getRequestDispatcher("/html/error.html").forward(request,response);
        }
    }
}
