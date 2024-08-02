package servlet;

import bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个用户对象
        User user = new User();
        user.setId("111111");
        user.setName("jack");

        //将用户对象存储到请求域中
        request.setAttribute("user01",user);

        //转发——是由WEB服务器来控制的。A资源跳转到B资源，这个跳转动作就是Tomcat服务器内部完成的
//        request.getRequestDispatcher("/b").forward(request,response);

        //重定向——是浏览器完成的。具体跳转到哪个资源，是浏览器说了算
        //重定向时的路径需要以项目名开始，或者说需要添加项目名
        //sendRedirect将"/Servlet10/b"响应给浏览器，浏览器又自发地向服务器发送一次请求：http://localhost:8080/Servlet10/b
        //所以浏览器一共发送了两次请求
        //第一次请求：http://localhost:8080/Servlet10/a
        //第二次请求：http://localhost:8080/Servlet10/b
        //最后浏览器地址栏上的地址就是第二次地址，从而导致浏览器地址栏上的地址发生改变
        response.sendRedirect(request.getContextPath() + "/b");
    }
}
