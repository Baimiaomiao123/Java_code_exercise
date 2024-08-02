package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 *  实现监听器的步骤：以ServletContextListener为例
 *      第一步：编写一个类，实现ServletContextListener接口，并实现里面的方法
 *      第二步：在web.xml对ServletContextListener进行配置。当然也可以使用注解的方式
 *
 */
//ServletContextListener主要监听的是：ServletContext对象的状态
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * 注意：所有的监听器中的方法都是不需要javaweb程序员调用，由服务器调用
     *  当某个特殊的事件发生之后（某个时机），被web服务器自动调用
     *
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //现在这个特殊的时刻写代码，它会被服务器自动调用
        //这个方法是在ServletContext对象被创建的时候调用
        System.out.println("ServletContext对象创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //现在这个特殊的时刻写代码，它会被服务器自动调用
        //这个方法是在ServletContext对象被销毁的时候调用
        System.out.println("ServletContext对象销毁");
    }
}
