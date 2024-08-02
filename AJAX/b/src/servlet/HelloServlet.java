package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置响应头，允许ajax跨域请求——解决方案一
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8081"); //允许某个
        //response.setHeader("Access-Control-Allow-Origin","*"); //允许所有
        //response.getWriter().print("hello ajax");

        response.getWriter().print("{\"username\" : \"zhangsan\"}");
    }
}
