package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    //通过无参数构造方法创建对象
//    public HelloServlet(){}

    //没有提供init方法，那么必然执行父类的HttpServlet中的init方法
    //HttpServlet中没有init方法，会执行它的父类GenericServlet中的init方法

    /*
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1>hello servlet</h1>");

    }
     */

    //当前端发送的请求是get请求的时候，在这里重写doGet方法

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1>goGet</h1>");

    }

    //当前端发送的请求是post请求的时候，在这里重写doPost方法

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1>goPost</h1>");
    }

    //两个方法重写一定不会报405错误。
    //只重写某一个方法：如果前端发送的是Get请求，但是在这里只重写了doPost请求
    //那么这个类就对去调用父类的doGet方法，父类的doGet方法就会提示405错误信息
    //整个代码的意思就是让前端发送的请求类型（Post、Get）与后端一致，否则就会报错
    //如果要是重写doGet和doPost方法，那还不如直接重写service方法，这样代码还简洁一点
}
