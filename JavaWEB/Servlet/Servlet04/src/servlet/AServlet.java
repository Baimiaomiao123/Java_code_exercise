package servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


/**
 * ServletContext
 * 1、ServletContext是什么？
 *  ServletContext是Servlet规范中的一员
 * 2、ServletContext是谁实现的
 *  Tomcat服务器（WEB服务器）实现了这个接口
 *  public class org.apache.catalina.core.ApplicationContextFacade implements ServletContext{}
 * 3、ServletContext对象是谁创建的？什么时候创建的？
 *  ServletContext对象在WEB服务器启动的时候创建的
 *  ServletContext对象是WEB服务器创建的
 *  对于一个webapp来说，ServletContext对象只有一个
 *  ServletContext对象在服务器关闭的时候销毁
 * 4、ServletContext怎么理解？
 *  Context是什么意思？
 *      Servlet对象的环境对象。（Servlet对象的上下文对象）
 *  ServletContext对象其实对应的就是整个web.xml文件
 *  50个学生，每一个学生都是Servlet，这50个学生都在同一个教室当中，那么这个教室就相当于ServletContext
 *  放在ServletContext对象当中的数据，所有Servlet一定是共享的
 *  例如：一个教室中的空调、黑板等等
 *  Tomcat是一个容器，一个容器当中可以放多个webapp，一个webapp对应一个ServletContext对象
 * 5、ServletContext接口中有哪些常用的方法？
 *  public String getInitParameter(String s); //通过初始化参数的name获取value
 *  public Enumeration<String> getInitParamterNames(); //获取所有的初始化参数name
 *
 *  以上两个方式是ServletContext对象的方法，这个方法获取的是什么信息？是以下的配置信息
 *  <context-param>
 *         <param-name>pageSize</param-name>
 *         <param-value>10</param-value>
 *     </context-param>
 *
 *     <context-param>
 *         <param-name>startIndex</param-name>
 *         <param-value>0</param-value>
 *     </context-param>
 *  注意：以上的配置信息属于应用的配置信息，一般一个项目中共享的配置信息会放到以上的标签中
 *  如果你的配置信息只是想给某一个servlet作为参考，那么你配置到servlet标签当中即可，使用ServletConfig对象
 *
 *  public String getContextPath(); //获取应用的根路径
 *  这个方法非常重要，因为在java源代码当中有一些地方可能会需要应用的根路径，这个方法可以动态获取应用的根路径
 *  在java源码当中，不要将应用的根路径血丝，因为你永远不知道这个应用最终部署的时候，起一个什么名字/
 *
 *  public String getRealPath(); //获取文件的绝对路径（真实路径）
 *
 *  public void log(String message); //通过ServletContext对象记录日志
 *  public void log(String message,Throwable t);
 *  这个日志会自动记录到/CATALINA_HOME/logs文件夹中(注意：这个CATALINA_HOME是IDEA中的——，不是系统中的)
 *  ~/Library/Caches/JetBrains/IntelliJIdea2022.3/tomcat/2ddb44b7-d33a-46ee-9e1d-885b1aaf696d/logs
 *      localhost_access_log.2023-03-01.txt——ServletContext对象的log方法记录的日志信息存储到这个文件中
 *      catalina.2023-03-01.log——服务器端java程序运行的控制台信息
 *      localhost.2023-03-01.log——访问日志
 */
public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        //获取ServletContext对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象：" + application); //ServletContext对象：org.apache.catalina.core.ApplicationContextFacade@1c832faa

        //获取上下文的初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print("<br>"+ name + "=" + value);
        }

        //获取context path（获取应用上下文的跟）
        String contextPath = application.getContextPath();
        out.print("<br>" + contextPath); //context

        //获取文件的绝对路径
        String realPath = application.getRealPath("/index.html"); // /代表当前项目的根路径（web），也可以不加"/"，默认起点就是根路径
        out.print("<br>" + realPath); // /Users/miaopeng/code/java/code_exercise/out/artifacts/Servlet04_war_exploded/index.html
    }
}
