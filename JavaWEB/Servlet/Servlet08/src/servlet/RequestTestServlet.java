package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  HttpServletRequest方法
 *      String getParameter(String name); //获取value这个一维数组当中的第一个元素（最常用）
 *      Map<String,String[]> getParameterMap(); //这个是获取Map
 *      Enumeration<String> getParameterNames(); //这个是获取Map集合中所有的key
 *      String[] getParameterValues(String name); //提取key获取Map集合的value
 *  以上的4个方法，和获取用户提交的数据有关系
 */
public class RequestTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(req); //org.apache.catalina.connector.RequestFacade@262cf65c
        //Tomcat的RequestFacade实现了HttpServletRequest接口

        //前端会提交什么数据呢？
        //username=zhangsan&userpwd=123&interest=s&interest=d&interest=f
        //以上的数据会被小猫咪封装到request对象中

        //获取参数Map集合
        Map<String,String[]> parameterMap = req.getParameterMap();
        //遍历Map集合（获取Map集合中所有的key，遍历）
        Set<String> keys = parameterMap.keySet();
        Iterator<String> it =keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            out.print("<br>" + key); //username userpwd hobby
            //通过key获取value
            String[] values = parameterMap.get(key);
            /*
            out.print("<br>" + key + "=" + values);
            username
            username=[Ljava.lang.String;@74960e6f
            userpwd
            userpwd=[Ljava.lang.String;@70a98425
            hobby
            hobby=[Ljava.lang.String;@35ab0454
             */
            for (String value:
                 values) {
                out.print("<br>" + key + "=" + value);
            }
            /*
            username
            username=zhangsan
            userpwd
            userpwd=123
            hobby
            hobby=s
            hobby=d
             */
        }

        //直接通过gerParameterNames()这个方法，可以直接获取这个Map集合的所有key
        Enumeration<String> names = req.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            out.print("<br>" + name);

            //直接通过name获取value这个一维数组
            String[] values = req.getParameterValues(name);
            for (String value:
                 values) {
                out.print("<br>" + value);
            }
            /*
            username
            zhangsan
            userpwd
            123
            hobby
            s
            d
             */
        }

        //通过name获取value这个一维数组的第一个元素
        //这方法使用最多，因为这个一维数组一般只有一个元素
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
//        String hobby = req.getParameter("hobby");
        String[] hobbies = req.getParameterValues("hobby");

//        out.print("<br>" + username + "," +userpwd + "," + hobby); //zhangsan,123,s
        for (String hobby:
             hobbies) {
            out.print("<br>" + hobby); //s d
        }
    }
}
