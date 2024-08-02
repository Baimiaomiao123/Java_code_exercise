package servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * 编写一个标准通用的Servlet，起名：GenericServlet
 * 以前所有的Servlet类都不要直接继承Servlet接口
 * 以后所有的Servlet类都要继承GenericServlet类
 * GenericServlet就是一个适配器
 */
public abstract class GenericServlet implements Servlet {

    private ServletConfig config;

    /**
     * init方法中的ServletConfig对象是Tomcat创建好的
     * 这个ServletConfig对象目前在init方法的参数上，属于局部变量
     * 那么ServletConfig对象肯定以后要在service方法中使用，那么怎么才能保证ServletConfig对象能在service方法中使用？
     * 使用成员变量!
     */
    @Override
    public final void init(ServletConfig config) throws ServletException {
//        System.out.println(config);
        this.config = config;
        this.init();
    }

    /*
        这个init方法供子类重写
     */
    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     * 这个方法最常用，所以要求子类必须实现service方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException;
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
