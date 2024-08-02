package servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2 doFilter begin");
        filterChain.doFilter(request,response);
        System.out.println("Filter2 doFilter end");
    }

    @Override
    public void destroy() {
    }
}
