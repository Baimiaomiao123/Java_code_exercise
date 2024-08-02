package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/proxy")
public class ProxyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //通过httpclient组件发送HTTP的GET请求，访问TargetServlet
        String url = "http://localhost:8080/b/target";
        HttpGet httpGet = new HttpGet(url);

        //设置类型
        httpGet.setHeader("Content-Type","application/x-www-form-urlencoded");

        //httpClient实例化
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //执行请求并获取数据返回
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();

        //显示结果
        BufferedReader reader = new BufferedReader(new InputStreamReader((entity.getContent()),"UTF-8"));
        String line = null;
        StringBuffer responseSB = new StringBuffer();
        while((line = reader.readLine()) != null){
            responseSB.append(line);
        }
        reader.close();
        httpClient.close();

        //b站点响应回来的数据在响应给前端
        response.getWriter().print(responseSB);
    }
}
