package servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class AServlet implements Servlet {

    //无参数构造

    public AServlet() {
        System.out.println("AServlet无参数构造方法...");
    }

    //init方法是初始化方法
    //自会执行一次
    //在对象第一次创建之后执行
    //init方法通常是完成初始化操作
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("AServlet's init method execute!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //处理用户请求的核心方法
    //只要用户发送一次请求，service方法就会执行一次
    //发送100次，就会执行100次service方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("AServlet's service method execute!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //destroy方法也是只执行一次
    //Tomcat服务器会在对象内存销毁之前再执行一次destroy方法
    //destroy方法在执行的时候，对象的内存还没有被销毁，但是即将被销毁
    //destroy方法可以编写销毁前的准备
    //例如：关闭数据库，关闭IO流等等
    @Override
    public void destroy() {
        System.out.println("AServlet's destroy method execute!");
    }
}
