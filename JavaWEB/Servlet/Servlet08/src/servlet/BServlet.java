package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getAttribute("sysTime");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("request域当中获取的当前时间：" + obj); //request域当中获取的当前时间：null

        //通过AServlet能不能跳转到BServlet
        //让AServlet和BServlet放到一次请求当中
        //可以的。使用Servlet当中请求转发机制。（下节课再说）
    }
}
