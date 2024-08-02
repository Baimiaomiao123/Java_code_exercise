package AjaxServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request1")
public class AjaxRequest1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //服务器的代码实际上还是和以前的代码是一样的
        //只不过这个out在响应的时候，浏览器客户端的XMLHttpRequest对象会接收到这个信息
        out.print("<font color = 'red'>welcome to study ajax!!!</font>");
    }
}
