package oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oa.util.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//模板类
//@WebServlet({"/dept/list","/dept/add","/dept/edit","/dept/delete","/dept/detail","/dept/update"})
@WebServlet("/dept/*") //模糊匹配，只要请求路径是以"/dept"开始的，都走这个servlet
public class DeptServlet extends HttpServlet {
    //模板方法
    //重写service方法（并没有重写doGet或者doPost）
    //将之前的Dept的各种类合并为方法，通过servletPath判断应该采用哪种方法
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletPath
        String servletPath = request.getServletPath();
        if("/dept/list".equals(servletPath)){
            doList(request,response);
        } else if ("/dept/add".equals(servletPath)) {
            doAdd(request,response);
        } else if ("/dept/edit".equals(servletPath)) {
            doEdit(request,response);
        } else if ("/dept/delete".equals(servletPath)) {
            doDel(request, response);
        } else if ("/dept/detail".equals(servletPath)) {
            doDetail(request, response);
        } else if ("/dept/update".equals(servletPath)) {
            doUpdate(request, response);
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("            <!DOCTYPE html>");
        out.print("    <html lang='en'>");
        out.print("    <head>");
        out.print("        <meta charset='UTF-8'>");
        out.print("        <title>部门详情</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("      <h1>部门详情</h1>");
        out.print("      <hr>");

        //获取部门编号
        // /oa/dept/detail?deptno=xx
        //即获取xx
        String deptno = request.getParameter("deptno");

        //连接数据库，根据部门编号查询部门信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select dname , loc from dept where deptno = ?" ;
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs = ps.executeQuery();
            //这个结果一定只有一条记录
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("部门编号：" + deptno + "<br>");
                out.print("部门名称：" + dname +"<br>");
                out.print("部门位置：" + loc + "<br>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }

        out.print("        <input type='button' value='后退' onclick='window.history.back()'/>");
        out.print("    </body>");
        out.print("    </html>");
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            request.getRequestDispatcher("/dept/list").forward(request,response);
        }else {
            //保存失败，跳转到失败页面
            request.getRequestDispatcher("/html/error.html").forward(request,response);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取应用的根路径
        String contextPath = request.getContextPath();

        //设置相应的内容类型及字符集，防止中文乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        out.print("        <!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>部门列表页面</title>");

        out.print("<script type='text/javascript'>");
        out.print("    function del(dno){");
        out.print("        if(window.confirm('亲，删除了数据不可恢复哟！')){");
        out.print("            document.location.href = '" + contextPath + "/dept/delete?deptno=' + dno;");
        out.print("        }");
        out.print("    }");
        out.print("</script>");

        out.print("</head>");
        out.print("<body>");
        out.print("  <h1 align='center'>部门列表页面</h1>");
        out.print("  <hr>");
        out.print("  <table border='1px' align='center' width='50%'>");
        out.print("    <tr align='center'>");
        out.print("      <th>序号</th>");
        out.print("      <th>部门编号</th>");
        out.print("      <th>部门名称</th>");
        out.print("      <th>操作</th>");
        out.print("    </tr>");
        /*上面一部分是死的*/

        //连接数据库，查询所有的部门，动态的展示部门列表页面
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //获取连接
            conn = DBUtil.getConnection();
            //获取预编译的数据库操作对象
            String sql = "select deptno as a,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();
            //处理结果集
            int i = 0;
            while (rs.next()){
                String deptno = rs.getString("a");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("    <tr align='center'>");
                out.print("      <td>" + (++i) +"</td>");
                out.print("      <td>" + deptno + "</td>");
                out.print("      <td>" + dname + "</td>");
                out.print("      <td>");
                out.print("        <a href='javascript:void(0)' onclick='del(" + deptno + ")'>删除</a>");
                out.print("        <a href='" + contextPath + "/dept/edit?deptno=" + deptno + "'>修改</a>");
                out.print("        <a href='" + contextPath + "/dept/detail?deptno=" + deptno + "'>详情</a>"); //技巧：重点向服务器提交的格式需要注意！！
                out.print("      </td>");
                out.print("    </tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtil.close(conn,ps,rs);
        }

        /*下面一部分是死*/
        out.print("  </table>");
        out.print("  <hr>");
        out.print("  <a href='" + contextPath + "/html/add.html'>新增部门</a>");
        out.print("</body>");
        out.print("</html>");
    }
}
