package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向request域对象中绑定数据
        Date nowTime = new Date();
        req.setAttribute("sysTime",nowTime);

        //从request域当中取出绑定数据
//        Object obj = req.getAttribute("sysTime");
//
        //输出到浏览器
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        out.print("request域当中获取的当前时间：" + obj); //request域当中获取的当前时间：Wed Mar 08 10:34:06 CST 2023

        //这样做可以吗？
        //在AServlet中new一个BServlet对象，然后调用BServlet对象的doGet方法，把req和resp传进去
        //这个代码虽然可以实现功能，但是Servlet对象不是由程序员new，而是应该由服务器来new，程序员new生命周期的不受Tomcat服务器的管理
//        BServlet bServlet = new BServlet();
//        bServlet.doGet(req, resp);

        //使用Servlet转发机制
        //执行了AServlet之后，跳转到BServlet（这个资源跳转可以使用转发机制完成）
        //怎么转发？代码怎么写？
        //第一步：获取请求转发器对象
        //相当于把url包装到请求转发器当中，实际上是把下一个跳转的资源封装到转发器对象中
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/b");

        //第二步：调用请求转发器RequestDispatcher的forward方法，把request和response传进去
        //转发的时候，这两个参数很重要，req和resq都是要传递给下一个资源的
//        requestDispatcher.forward(req,resp);

        //第一步和第二步可以合并一起写
        req.getRequestDispatcher("/user/b").forward(req,resp);


        //转发的下一个资源必须是一个Servlet吗？
        //不一定，只要是Tomcat服务器当中的合法资源，都是可以转发的。例如：html
        //注意：转发的时候，路径的写法要注意，转发的路径以"/"开始，不加项目名

        //转发到一个html，只要是web服务器当中的合法服务器即可
//        req.getRequestDispatcher("/Test.html").forward(req,resp);

    }
}

/*
    关于request对象中两个非常容易混淆的方法：
        String username = req.getParameter("username");
        Object obj = req.getAttribute("name");

        以上两个方法的区别？
            第一个方法获取的是用户在浏览器上提交的数据
            第二个方法获取的是请求域当中绑定的数据
 */
