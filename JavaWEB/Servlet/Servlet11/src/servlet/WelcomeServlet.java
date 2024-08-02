package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = {"/welcome1","welcome2"})
//注意，当注解的属性是一个数组，并且数组中只有一个元素，大括号可以省略不写
//@WebServlet(urlPatterns = "/welcome")
//@WebServlet(value = {"/welcome1","/welcome2"})
//如果注解的属性名是value的话，属性名也是可以省略的
//@WebServlet(value = "welcome")
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("欢迎学习Servlet");
    }
}
