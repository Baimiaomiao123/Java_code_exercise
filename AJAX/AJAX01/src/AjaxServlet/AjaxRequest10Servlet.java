package AjaxServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 将AJAX请求封装到jQuery当中
 */
@WebServlet("/request10")
public class AjaxRequest10Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String uname = request.getParameter("username");
        //{"name":"zhangsan"}
        response.getWriter().print("{\"uname\":\"" + uname + "\"}");

    }
}
