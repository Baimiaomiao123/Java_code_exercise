package oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oa.bean.Dept;
import oa.util.DBUtil;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dept/list","/dept/detail","/dept/delete","/dept/add","/dept/update"})
public class DeptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //入口的验证
        //获取的session，只是获取当前的session，获取不到就返回null
//        HttpSession session = request.getSession(false);
//        if(session != null && session.getAttribute("username") != null) {
//            //表示登陆过，就可以进行以下操作
            String servletPath = request.getServletPath();
            if ("/dept/list".equals(servletPath)) {
                doList(request, response);
            } else if ("/dept/detail".equals(servletPath)) {
                doDetail(request, response);
            } else if ("/dept/delete".equals(servletPath)) {
                doDel(request, response);
            } else if ("/dept/add".equals(servletPath)) {
                doAdd(request, response);
            } else if ("/dept/update".equals(servletPath)) {
                doUpdate(request, response);
            }

    }

    /**
     * 更新修改的部门详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
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
            response.sendRedirect(request.getContextPath() + "/html_new/error.jsp");
        }
    }

    /**
     * 添加部门
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //获取部门的信息
        //注意乱码问题
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        //连接数据库执行insert语句
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into dept(deptno,dname,loc) value(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {

            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }

        if (count==1) {
            //保存成功，跳转到列表页面
            //转发是一次请求，由于DeptAddServlet是doPost请求，转给list会发生405错误
//            request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }else {
            //保存失败，跳转到失败页面
//            request.getRequestDispatcher("/html/error.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath() + "html_new/error.jsp");
        }
    }


    /**
     *根据部门编号删除部门
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //获取部门编号
        String deptno = request.getParameter("deptno");

        //连接数据库，删除部门
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,null);
        }

        if (count==1) {
            //更新成功
            //重定向到list页面
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }
    }


    /**
     * 根据部门编号获取部门信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //创建部门对象
        Dept dept = new Dept();
        //获取部门编号
        String deptno = request.getParameter("deptno");

        //根据部门编号获取部门信息，将部门信息封装到咖啡豆
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select dname,loc from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs = ps.executeQuery();
            //这个结果集当中只有1跳数据，不需要while循环
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //封装对象（创建豆子）
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);
            }
        } catch (SQLException e) {

        } finally {
            DBUtil.close(conn,ps,rs);
        }

        //这里豆子只有一个，所以不需要袋子。只需要将这个豆子放到request域当中即可
        request.setAttribute("dept",dept);

        //转发（不是重定向，因为要跳转到JSP做数据展示）
        //request.getRequestDispatcher("/html/detail.jsp").forward(request,response);
        /*
        String flag = request.getParameter("flag");
        if("update".equals(flag)){
            //转发到修改页面
            request.getRequestDispatcher("/html/edit.jsp").forward(request,response);
        } else if ("detail".equals(flag)) {
            //转发到详情页面
            request.getRequestDispatcher("/html/detail.jsp").forward(request,response);
        }
         */
        String forward = "/html_new/" + request.getParameter("flag") + ".jsp";
        request.getRequestDispatcher(forward).forward(request,response);
    }

    /**
     * 连接数据库，查询所有的部门信息，将部门信息手机号，然后跳转到JSP信息做页面展示
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //准备一个容器，用来专门存储部门
        List<Dept> depts = new ArrayList<>();

        //连接数据库，查询所有的部门信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //获取连接
            conn = DBUtil.getConnection();
            //执行查询语句
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //遍历结果集
            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                //将以上零散的数据封装成java对象
                Dept dept = new Dept();
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);

                //将部门对象放到list集合当中
                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtil.close(conn,ps,rs);
        }

        //将一个集合放到请求域当中
        request.setAttribute("deptList",depts);

        //转发（不要重定向）
        request.getRequestDispatcher("/html_new/list.jsp").forward(request,response);
    }
}
