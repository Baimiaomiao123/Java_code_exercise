package AjaxServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request7")
public class AjaxRequest7Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接受的中文会不会乱码？ 不会
        String username = request.getParameter("username");
        System.out.println(username);
        //响应中文会不会有乱码？ 9及之前会有乱码
//        response.setContentType("text/html;charset=UTF-8"); //9及之前会有乱码，设置这个就好
        PrintWriter out = response.getWriter();
        out.print(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接受的中文会不会乱码？ 9及之前会有乱码
//       request.setCharacterEncoding("UTF-8")
        String username = request.getParameter("username");
        System.out.println(username);
        //响应中文会不会有乱码？ 9及之前会有乱码
//        response.setContentType("text/html;charset=UTF-8"); //9及之前会有乱码，设置这个就好
        PrintWriter out = response.getWriter();
        out.print(username);
    }
}
