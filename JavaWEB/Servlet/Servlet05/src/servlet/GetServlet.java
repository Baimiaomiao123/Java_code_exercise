package servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //响应一些内容到一些浏览器上
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        out.print("<!doctype html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>from get servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>from get servlet</h1>");
        out.print("</body>");
        out.print("</html>");
    }
}
