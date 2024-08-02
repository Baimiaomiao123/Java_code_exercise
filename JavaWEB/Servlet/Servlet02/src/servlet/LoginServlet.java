package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginServlet extends GenericServlet{

    /*
        思考一个问题：
            有没有一种可能，需要我在LoginServlet类中重写init方法？
            当然有可能，于是重写init方法
     */

    /*在父类GenericServlet加一个final修饰符
        public final void init(ServletConfig config) throws ServletException {
            this.config = config;
    }
     */
    //这样就可以强制子类不能重写init方法，但是还是希望重写init方法怎么办呢？
    /*
        在init中写init方法
        public final void init(ServletConfig config) throws ServletException {
            this.config = config;
            this.init();
        }

        public void init(){

        }
     */


    @Override
    public void init(){
        System.out.println("LoginServlet's init() method execute!");
        System.out.println("config：" + this.getServletConfig());
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("正在处理用户登陆请求，请稍后...");

        //如果在Login子类中使用ServletConfig对象怎么办？
        //直接使用当前类的getServletConfig方法得到私有ServletConfig属性
        ServletConfig config = this.getServletConfig();
        System.out.println("service方法中是否可以拿到ServletConfig对象？" + config);
    }
}
