package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/jsonp1")
public class JSONPServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //在后台输出
        //System.out.println("jsonp方式完成跨域访问");

        //向前端响应一段js代码呢？
        //response.getWriter().print("alert(123)"); //这是响应一段js代码，只不过这个alert函数是JS内置的函数，可以直接用
        //注意：不要误认为是后段java代码调用了sayHello函数。实际上后段只是向前端发送了一段字符串响应给了script块
        //这段代码块会被script块将其当作js代码执行
        //response.getWriter().print("sayHello();"); //这里

        //响应一段js代码，然后传一个json给前端
        //response.getWriter().print("sayHello({\"name\" : \"jackson\"})");
        //动态获取函数名
        String fun = request.getParameter("fun");
        response.getWriter().print(fun +"sayHello({\"name\" : \"jackson\"})");
    }
}
