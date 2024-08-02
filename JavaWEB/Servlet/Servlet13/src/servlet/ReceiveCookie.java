package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sendcookie")
public class ReceiveCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //通过java程序怎么接收到浏览器发送过来的cookie呢
        //当然通过request对象
        //注意细节，这方法可能会返回null，如果浏览器没有提交cookie，这个方法返回值为null，并不是返回一个长度为0的Cookie数组
        Cookie[] cookies = request.getCookies();

        //如果不是null，表示一定有cookie
        if (cookies != null) {
            for (Cookie cookie:
                    cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + "=" + value);
            }
        }


    }
}
