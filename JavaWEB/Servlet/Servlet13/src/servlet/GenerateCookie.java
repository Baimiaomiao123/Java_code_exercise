package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie/generate")
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie对象
        Cookie cookie = new Cookie("product","123456789"); // product=123456789
        Cookie cookie2 = new Cookie("username","zhangsan");

        //设置cookie在一小时之后失效
        //cookie.setMaxAge(60 * 60); // product=123456789; Max-Age=3600; Expires=Sun, 12 Mar 2023 13:04:12 GMT
        //如果没有设置cookie有效时间，默认保存在浏览器的运行内存中，浏览器关闭则cookie消失
        //只要设置cookie有效时间>0，这个cookie一定会存储到硬盘文件当中
        //那么设置cookie的有效时间=0或者<0呢？
        //设置cookie的有效期为0，表示cookie被删除，主要应用在：使用这种方式删除浏览器上的同名cookie
        //cookie.setMaxAge(0); //product=123456789; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:10 GMT
        //设置cookie的有效期<0，表示cookie不会被存储到硬盘文件中，会放在浏览器的运行内存中
        cookie.setMaxAge(-1); //product=123456789，和不调用setMaxAge是同一个效果

        //默认情况下，没有设置path的时候，cookie关联的路径是什么？
        // http://localhost:8080/Servlet13/cookie以及它的子路径
        cookie.setPath(request.getContextPath()); // Path=/Servlet13，表示只要是这个Servlet13项目的请求路径，都会提交这个cookie给服务器
        cookie2.setPath(request.getContextPath());

        //将cookie响应到浏览器
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }
}
