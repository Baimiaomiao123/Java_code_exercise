package servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigTestServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        //获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        //输出
        out.println("ServletConfig对象：" + config); //ServletConfig对象：org.apache.catalina.core.StandardWrapperFacade@30d76b9f

        String value = config.getInitParameter("key");
        out.print("<br>" + value);
    }
}
