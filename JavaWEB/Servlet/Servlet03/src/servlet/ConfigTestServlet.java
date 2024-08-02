package servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletConfig
 *  1、ServletConfig的是什么？
 *      jakarta.servlet.ServletConfig
 *      显然ServletConfig是Servlet规范中的一员
 *      ServletConfig是一个接口（jakarta.servlet.Servlet也是一个接口）
 *  2、谁去实现了这个接口？ ——WEB服务器实现了
 *      public class org.apache.catalina.core.StandardWrapperFacade@33f5ce13 {}
 *      结论是：Tomcat服务器实现了这个接口
 *      思考：如果把Tomcat服务器换成jetty服务器，输出ServletConfig对象的时候还是这个东西吗？
 *          不一定一样。包名类名可能和Tomcat不一样，但是他们都实现了ServletConfig接口
 *  3、一个Servlet对象中有一个ServletConfig对象（Servlet和ServletConfig对象是一对一）
 *      100个Servlet就应该有100个ServletConfig
 *  4、ServletConfig对象是谁创建的？在什么时候创建的？
 *      Tomcat服务器（WEB服务器）创建了ServletConfig对象
 *      在创建Servlet对象的时候同时创建了ServletConfig对象
 *  5、ServletConfig接口到底是干啥的？有什么用呢？
 *      Config——Configuration
 *      ServletConfig对象被翻译为：Servlet对象的配置信息对象
 *      一个Servlet就有一个配置信息对象
 *
 *  6、ServletConfig对象到底包装了什么信息呢？
 *      <servlet>
 *         <servlet-name>configTest</servlet-name>
 *         <servlet-class>servlet.ConfigTestServlet</servlet-class>
 *     </servlet>
 *     ServletConfig对象包装的信息是：
 *         web.xml文件中<servlet></servlet>标签的配置
 *
 *     Tomcat解析web.xml文件，将web.xml文件中<servlet></servlet>标签中的信息配置信息自动包装到ServletConfig对象中
 *  7、ServletConfig接口中有哪些方法？
 *       <servlet>
 *         <servlet-name>configTest</servlet-name>
 *         <servlet-class>servlet.ConfigTestServlet</servlet-class>
 *         <!--这里是可以配置一个Servlet对象的配置信息的-->
 *         <init-param>
 *             <param-name>driver</param-name>
 *             <param-value>com.mysql.cj.jdbc.Driver</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>url</param-name>
 *             <param-value>jdbc:mysql://localhost:3306/test</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>user</param-name>
 *             <param-value>root</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>password</param-name>
 *             <param-value>mp102030..</param-value>
 *         </init-param>
 *     </servlet>
 *     以上Servlet标签中的init-param是初始化参数，这个初始化参数会被自动封装到Tomcat创建的ServletConfig对象中
 *  8、ServletConfig接口中有4个方法
 *      第一个方法：
 *          public String getInitParameter(String name);
 *      第二个方法：
 *          public Enumeration<String> getInitParameterNames();
 *      第三个方法：
 *          public ServletContext getServletContext();
 *      第四个方法：
 *          public String getServletName();
 *
 *      以上的四个方法，在自己编写的Servlet类中也可以使用this去调用（这个Servlet继承了GenericServlet）
 */
public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        //获取ServletConfig对象
        ServletConfig config = this.getServletConfig();

        //输出该对象
        out.println("ServletConfig的对象：" + config); //ServletConfig的对象：org.apache.catalina.core.StandardWrapperFacade@33f5ce13
        out.println("<br>");

        //获取<servlet-name></servlet-name>
        String servletName = config.getServletName();
        out.println("<servlet-name>" + servletName + "</servlet-name>");
        out.println("<br>");

        //通过ServletConfig对象的两个方法，可以获取到web.xml文件中的初始化参数配置信息
        //获取所有初始化参数的name
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        //遍历集合
        while(initParameterNames.hasMoreElements()){
            String parameterName = initParameterNames.nextElement();
            //通过name获取value
            String parameterVal = config.getInitParameter(parameterName);
            out.println(parameterName);
            out.println("<br>");
        }

        /*
        //获取初始化参数的name
        String driver = config.getInitParameter("driver");
        out.print(driver);
         */

        //实际上一个Servlet对象的初始化参数，可以不用获取ServletConfig对象，直接用this就可以
        Enumeration<String> names = this.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = this.getInitParameter(name);
            out.print("<br>" + name + "=" + value);
        }

        out.print("<br>");

        //怎么获取Servlet对象呢？
        //第一种方式：通过ServletConfig对象获取ServletContext对象
        ServletContext application = config.getServletContext(); //org.apache.catalina.core.ApplicationContextFacade@46a1801d
        //输出
        out.println("<br>" + application);
        //第二种方式：通过this获取ServletContext对象
        ServletContext application2 = this.getServletContext(); //org.apache.catalina.core.ApplicationContextFacade@46a1801d
        out.println("<br>" + application2);

    }
}
