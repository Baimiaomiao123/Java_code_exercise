package oa.web.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        /**
         *   什么情况下不能拦截？
         *      目前写的路径是：/* ——均拦截
         *
         *      用户访问index.jsp的时候不能拦截
         *      用户登陆了，这个需要放行，不能拦截
         *      用户要去登陆，这个也不能拦截
         *      WelcomeServet也不能拦截
         */

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //获取请求路径
        String servletPath = request.getServletPath();

        HttpSession session = request.getSession(false);
        if("/index.jsp".equals(servletPath) || "/welcome".equals(servletPath) ||
               "/user/login".equals(servletPath) || "/user/exit".equals(servletPath) ||
                (session != null && session.getAttribute("username") != null)) {
            //继续往下走
            filterChain.doFilter(request,response);
        } else {
            //没有登陆过，跳转到登陆页面
            response.sendRedirect(request.getContextPath() + "/index.jsp"); //访问web站点的根，自动找到欢迎页面
        }
    }
}
