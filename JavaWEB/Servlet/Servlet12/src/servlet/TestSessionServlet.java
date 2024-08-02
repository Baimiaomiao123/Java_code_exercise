package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test/session")
public class TestSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request和session都是服务器端的java对象，都在JVM当中
        //request对象代表了一次请求（一次请求对应一个request对象。两次请求就会对应两个不同的request对象）
        //session对象代表了一次会话（一次会话对应一个session对象）

        //session机制属于B/S结构的一部分，如果使用PHP开发WEB项目，同样也有session机制。（session机制是一种规范，不同的语言对这种会话机制都有实现）
        //使用session机制可以保存会话状态
        //为什么需要session机制保存会话状态？因为Http协议是一种无状态协议（请求的时候，B和S是连接的，但是请求结束之后，协议就断了。为什么要设计成这样？——减小服务器压力）

        //获取session对象(对应的对象为：jakarta.servlet.http.HttpSession)
        HttpSession session = request.getSession();

        //向会话域当中绑定数据
        //session.setAttribute();
        //向会话域当中取数据
        //Object obj = session.getAttribute();

        //将session对象响应到浏览器
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("会话对象：" + session);
    }
}

/*
    session的实现原理：
        JSESSIONID=xxxxx，这个十一Cookie的形式保存在浏览器的内存中的，浏览器只要关闭，这个Cookie就没有了
        session列表是一个Map，map的key是sessionid，map的value是session对象
        用户第一次请求，服务器生成session对象，同时生成id，将id发送给浏览器
        用户第二次请求，自动将浏览器内存中的id发送给服务器，服务器根据id查找session对象
        关闭浏览器，内存消失，Cookie消失，sessionid消失，会话等同结束
    Cookie禁用了session还能找到吗？
        Cookie禁用是什么意思？服务器正常发送cookie给浏览器，但是浏览器不要了，拒收了。并不是服务器不发了
        找不到了。每次一请求都会获取到新的cookie对象
        cookie禁用了，session机制还能用吗？
            可以。需要使用URL重写机制。
            重写格式：http://localhost:8080/Servlet12/test/session;jsessionid=B2241181D8DA39A7C6CC9EA263BEB5D3
            URL重写机制会提高开发者的成本。开发人员在编写任何请求路径都要加一个sessionid。所以大部分的网站都是这样设计的：你要是禁用就别用cookie了


    总结一下到目前为止我们了解的域对象
        request(HttpServletRequest)
            请求域（请求级别，每请求一次就有）
        session(HttpSession)
            会话域（用户级别，个体用户私有的）
        application(ServletContext)
            应用域（项目级别，所有用户共享的）
        这三个域的大小关系
            request < session < application
        它们三个域都有以下共同的方法：
            setAttribute(向域当中绑定数据)
            getAttribute(从域当中获取数据)
            removeAttribute(从域当中删除数据)
        使用原则：尽量使用小的域
 */
