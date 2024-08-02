package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
    一个过滤器怎么写？
        第一步：编写一个java类实现jakarta.servlet.Filter。并且实现这个接口的所有方法
            init方法：在Filter对象第一次被创建之后调用，并且只调用一次
            doFilter方法：只要用户发送一次请求，则执行一次。发送N次请求，执行N次
            destroy方法：在Filter对象被释放/销毁之前调用，并且只调用一次
        第二步：在web.xml文件中对Filter进行配置。这个配置和Servlet很像

        注意：
            Servlet对象默认情况下，在服务器启动的时候不会创建对象的。
            Filter对象默认情况下，在服务器启动的时候会新建对象
            Servlet是单例的。Filter也是单例的

        目标Servlet是否执行，取决于两个条件：
            第一：在过滤器当中是否编写了：chain.doFilter(request,response);
            第二：用户发送的请求路径是否和Servlet的请求路径一致

        chain.doFilter(request,response)这行代码的作用：
            执行下一个过滤器，如果下面没有过滤器就执行最终Servlet

        注意：Filter的优先级，天生的就比Servlet优先级高
            /a.do对应一个Filter，也对应一个Servlet。那么一定先执行Filter，然后再执行Servlet

        关于Filter的配置路径：
            /a.do、/b.do、/dept/save这些配置方式都是精确匹配
            /* 匹配所有路径
            *.do 后缀匹配，不要以/开始
            /dept/* 前缀匹配

        注意：在web.xml文件中配置的时候：执行顺序——依靠mapping标签的位置越靠上，优先级越高
        过滤器的调用顺序，遵循栈数据结构

        使用@WebFilter的时候，Filter的执行顺序是怎么样的呢？
        根据类名的先后顺序执行（Filter1先，Filter2后）

        Filter的生命周期？
        和Servlet对象生命周期一致。唯一的区别：Filter默认情况下，在服务器启动阶段就实例化，Servlet不会

        Filter过滤器这里有一个设计模式：
        责任链设计模式
        最大的优点：在程序编译阶段不会确定调用顺序，因为Filter的调用顺序是配置到web.xml文件中的。只要修改web.xml配置文件中的Filter-mapping
        就可以调整Filter的执行顺序，显然Filter的执行顺序是在2程序运行阶段动态组合的。那么这种设计模式就被称为责任链设计模式
        责任链设计模式最大的核心思想：在程序运行开放阶段的时候，动态的组合程序的调用顺序
 */



//@WebFilter("/abc")
//@WebFilter("/a.do")
//@WebFilter("/b.do")
//@WebFilter({"/a.do","/b.do"})
@WebFilter("*.do") //这种写法属于模糊匹配中的扩展匹配，以星号开始，注意这种路径不要以/开始
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init method execute!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //在请求的时候添加过滤规则
        System.out.println("doFilter method execute!");

        //执行下一个过滤器，如果下一个不是过滤器了，则执行目标程序Servlet
        //向下走，没有它不可以
        filterChain.doFilter(request,response);

        //在响应的时候添加过滤规则
        System.out.println("doFilter method end!");
    }

    @Override
    public void destroy() {
        System.out.println("destroy method execute!");
    }
}
