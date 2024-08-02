package servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *  ServletContext对象还有另一个名字：应用域（后面还有其他域，例如：请求域，会话域）
 *  如果所有的用户共享一份数据，并且这个数据很少的修改，并且这个数据量很少，可以将这些数据放到ServletContext这个应用域中
 *  为什么所有用户共享的数据？
 *      不是共享的没有意义。因为ServletContext对象只有
 *  为什么数据量要小？
 *      因为数据量比较大的话，太占用堆内存，并且这个对象的生命周期比较长，服务器关闭的时候，这个对象才会被销毁
 *      大数据量会影响服务器的性能，占用内存较小的数据量可以考虑放进去
 *  为什么这个共享数据很少的修改，或者说几乎不能修改？
 *      所有用户共享的数据，如果涉及到修改操作，必然会存在线程并发所带来的安全问题。所以防在ServletContext对象中的数据
 *      一般都是只读的
 *
 *  数据量小、所有用户共享，又不修改，这样的数据放到ServletContext这个应用域中，会大大提升效率
 *  因为应用域相当于一个缓存，放到缓存中的数据，下次再用的时候不需要从数据库中再次获取，大大提升执行效率
 *
 *  存（怎么向ServletContext应用域中存数据）
 *      public void setAttribute(String name,Object value); //map.put(k,v)
 *  取（怎么从ServletContext应用域中取数据）
 *      public void getAttribute(String name); //Object v = map.get(k)
 *  删（怎么删除ServletContext应用域中的数据）
 *      public void removeAttribute(String name); //map.remove(k)
 *
 *  注意：以后我们编写Servlet类的时候，实际上是不会去直接继承GenericServlet类的，因为我们是B/S系统架构
 *  这种系统是基于HTTP超本文传输协议的。在Servlet规范当中，提供了一个类叫做HttpServlet，它是专门为HTTP协议
 *  准备的一个Servlet类，我们写的Servlet类要继承HttpServlet（HttpServlet是HTTP协议专用的）
 *  但是你需要知道它的继承结构：
 *      HttpServlet类继承GenericServlet抽象类
 *      GenericServlet抽象类又实现了Servlet接口
 *  我们以后编写的要继承HttpServlet类
 */
public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        //获取ServletContext对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象：" + application); //ServletContext对象：org.apache.catalina.core.ApplicationContextFacade@1c832faa

        //log
        application.log("Servlet's log......");

        //int age = 17;
        //当年龄小于18岁，非法。记录日志
        //if(age < 18){
        //    application.log("对不起，您未成年，请绕行",new RuntimeException("小屁孩，快走开，不适合你！"));
        //}

        User user = new User("jack","123");
        //向ServletContext应用域中存数据
        application.setAttribute("userObj",user);

        //取
        Object userObj = application.getAttribute("userObj");
        //输出到浏览器
        out.print("<br>" + userObj); //User{name='jack', password='123'}
        //注意：也可以在AServlet中存，BServlet中取，因为这个是同一个webapp下的，数据是共享的
    }
}
