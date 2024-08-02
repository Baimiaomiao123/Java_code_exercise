package oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import oa.util.CookieUtil;
import oa.util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet({"/user/login","/user/exit"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/user/login".equals(servletPath)){
            doLogin(request,response);
        }else if ("/user/exit".equals(servletPath)){
            doExit(request,response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //获取session对象，销毁session
        HttpSession session = request.getSession(false);
        //获取cookie对象，销毁cookie
        Cookie[] cookies = request.getCookies();


//        //如果cookie不为空，那么删除通过增强循环来删除cookie
//        if (cookies != null){
//
//            for (Cookie cookie:
//                 cookies) {
//
//                    cookie.setValue(null);
//                    cookie.setMaxAge(0);
//                    //一般我们删除cookie的方法是用一个同样名字、过期时间为过去某个时候的Cookie覆盖之。
//                    //这时就一定要搞清楚你要删除的cookie的域和路径，Cookie域和路径要一样才能被覆盖。
//                    //否则产生的效果就是那个想要被删除的Cookie具有神奇的生命力，无法被清除～～～
//                    cookie.setPath(request.getContextPath());
//                    System.out.println("被删除的cookie的名字为：" + cookie.getName());
//                    response.addCookie(cookie);
//                }
//
//            //后台输出删除的提示信息
//            System.out.println("已经完全删除cookie！");
//        }

        CookieUtil cookieUtil = new CookieUtil(request,response);
        cookieUtil.DeleteAllCookie();

        //如果session不会空，手动销毁session对象s
        if (session != null) {
            //手动销毁session对象(invalidate方法)
            session.invalidate();

            //后台输出删除的提示信息
            System.out.println("已经完全删除session！");

        }

        //跳转到登陆页面
        request.getRequestDispatcher("/welcome").forward(request,response);
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean success = false;
        /*验证用户名是否正确*/
        //获取用户名和名吗
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //连接数据库验证用户名和密码
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from t_user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            //这个结果集最多只有一条数据，或者没有
            if (rs.next()) {
                 //登陆成功
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }

        //登陆成功/失败
        if (success){
            //获取session对象(这里的要求是：必须获取到session；没有session必须新建一个session)
            HttpSession session = request.getSession(); //这里没有false，session一定不为空！！
            session.setAttribute("username",username);

            //登陆成功了，并且用户确实选择了"十天内免登录"功能
            String f = request.getParameter("f");
            if("1".equals(f)){
                //创建cookie对象存储登陆名和密码
                Cookie cookie1 = new Cookie("username",username);
                Cookie cookie2 = new Cookie("password", password); //真实情况下是加密的
                //设置cookie的有效期为十天
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);
                //设置cookie的path（只要访问这个应用，浏览器就一定要携带这两个cookie）
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                //响应cookie给浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }

            //成功，跳转到用户列表页面
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else {
            //失败，跳转到失败页面
            response.sendRedirect(request.getContextPath()+"/html_new/error.jsp");
        }
    }
}

/*
    怎么利用session解决项目中的登陆问题，让登陆起作用（避免用户直接输入List的url进入列表页面）？
        登陆成功之后，可以将用户的登陆信息存储到session当中，也就是说session中如果有用户的信息就代表用户登陆成功了
        如果session中没有用户信息，表示用户没有登陆过，则跳转到登陆页面
 */