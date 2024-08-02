package AjaxServlet;

import bean.Area;
import com.alibaba.fastjson2.JSON;
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

/**
 * 动态获取对应的区域
 */
@WebServlet("/listArea")
public class ListArrServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Area> ListArea = new ArrayList<>();
        String sql = null;
        String pcode = request.getParameter("pcode");

        //连接数据库，获取所有的对应区域，最终响应一个JSON格式的字符串给WEB前端
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "mp102030..";
            conn = DriverManager.getConnection(url,user,password);
            if (pcode == null){
                sql = "select code,name from t_area where pcode = 'null'";
                ps = conn.prepareStatement(sql);
            }else {
                sql = "select code,name from t_area where pcode = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,pcode);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                Area area = new Area();
                area.setCode(code);
                area.setName(name);
                ListArea.add(area);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

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

        String json = JSON.toJSONString(ListArea);
        response.getWriter().print(json);
    }
}
