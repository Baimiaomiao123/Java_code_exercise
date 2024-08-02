package AjaxServlet;

import bean.Student;
import com.alibaba.fastjson2.JSON;
import com.mysql.cj.xdevapi.JsonString;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/request5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //连接数据库，查询学生信息，拼接HTML代码，响应HTML代码到浏览器
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//        //连接到数据库，拼接HTML代码
//        StringBuilder html = new StringBuilder();
//
//        //目前存在的缺点：又在java后段代码中拼接前端代码，不好维护
//        //能不能直接将数据返回，给WEB前端数据就行了。让WEB前端能够拿到数据就行，然后页面展示的功能交给WEB前端来处理
//        //后段的java代码能不能只返回数据？？可以（返回数据可以采用JSON格式或XML格式）
//        html.append("         <tr>");
//        html.append("    <th>1</th>");
//        html.append("    <th>李四</th>");
//        html.append("    <th>22</th>");
//        html.append("    <th>北京海淀区</th>");
//        html.append("  </tr>");
//
//        out.print(html);

        //将以上程序拼接HTML，转成JSON格式的字符串
//        String jsonStr = "[{\"name\":\"王五\",\"age\":20,\"addr\":\"北京大兴区\"}," +
//                "{\"name\":\"李四\",\"age\":22,\"addr\":\"北京海淀区\"}]";

        //连接数据库，查询所有用户，拼接json字符串
        //准备StringBuilder对象，拼接JSON
        StringBuilder jsonStr = new StringBuilder();
//        String jsonstr = "";
        String jsonString = "";
        List<Student> studentList = new ArrayList<>();

        //连接数据库验证用户名是否存在
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mp102030..");
            //获取预编译的数据库操作对象
            String sql = "select name,age,addr from student";
            ps = conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();
            //处理结果集
//            jsonStr.append("[");
//            while (rs.next()) {
//                //获取每个学生的信息
//                String name = rs.getString("name");
//                String age = rs.getString("age");
//                String addr = rs.getString("addr");
//                //拼接json格式的字符串
//                //{"name":"  王五  ","age":  20  ,"addr":"  北京大兴区  "},
//                jsonStr.append("{\"name\":\"");
//                jsonStr.append(name);
//                jsonStr.append("\",\"age\":");
//                jsonStr.append(age);
//                jsonStr.append(",\"addr\":\"");
//                jsonStr.append(addr);
//                jsonStr.append("\"},");
//            }
//            jsonstr = jsonStr.substring(0, jsonStr.length() - 1) + "]";
            //使用fastjson代替上面的代码
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String addr = rs.getString("addr");
                //将以上数据封装成Student对象
                Student stu = new Student();
                stu.setName(name);
                stu.setAge(age);
                stu.setAddr(addr);
                studentList.add(stu);
            }
            //将List集合转换成JSON字符串
            jsonString = JSON.toJSONString(studentList);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //响应JSON格式的字符串给前端
        out.print(jsonString);
    }
}

