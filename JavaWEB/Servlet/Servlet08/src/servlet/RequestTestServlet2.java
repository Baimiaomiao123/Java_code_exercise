package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RequestTestServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Tomcat9及以前，响应域收到乱码，可以使用setContentType()方法，里面传参数charset=UTF-8
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        //获取客户端的ip地址
        String remoteAddr = req.getRemoteAddr();
        out.print("客户端的ip地址为：" + remoteAddr); //127.0.0.1

        //get请求在请求行上提交数据
        //post请求在请求体中提交数据
        //设置请求体的字符集——显然这个方法是处理post请求的乱码问题
        //Tomcat10之后，request请求体当中的字符集默认就是UTF-8，不用单独设置
        //Tomcat9及以前，如果前端是中文提交，后端就会收到乱码，可以使用setCharacterEncoding()方法
        req.setCharacterEncoding("UTF-8");

        //get请求的乱码怎么解决？
        //方法：修改CATALINA_HOME/conf/server.xml配置文件的Connector标签
        //<Connector URIEncoding="UTF-8"/>
        //Tomcat8之后，URIEncoding默认的就是UTF-8，不用修改

        //获取应用的根路径
        String contextPath = req.getContextPath();
        out.print("<br>" + "应用的根路径：" + contextPath); // /Servlet08

        //获取请求方式
        String method = req.getMethod();
        out.print("<br>" + method);

        //获取请求的URI
        String requestURI = req.getRequestURI();
        out.print("<br>" + "URI：" + requestURI); // /Servlet08/user/request2

        //获取Servlet的路径
        String servletPath = req.getServletPath();
        out.print("<br>" + "ServletPath：" + servletPath); // /user/request2
    }
}
