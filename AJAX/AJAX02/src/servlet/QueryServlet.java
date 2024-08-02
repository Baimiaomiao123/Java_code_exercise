package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户输入的关键字
        String keywords = request.getParameter("keywords");
        //jdbc代码连接数据，根据关键字查询数据库，拼接json格式的字符串
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "mp102030..";
            conn = DriverManager.getConnection(url,user,password);
            String sql = "select content from t_ajax where content like ?"; //模糊查询的时候，条件不建议使用%开始，因为会让字段上的索引失效，查询效率降低
            ps = conn.prepareStatement(sql);
            ps.setString(1,keywords + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                String content = rs.getString("content");
                sb.append("{\"content\":\"" + content + "\"},");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(sb.substring(0,sb.length()-1) + "]");

    }
}
