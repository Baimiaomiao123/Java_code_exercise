package servlet;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpClientSendGet {
    public static void main(String[] args) throws IOException {
        //使用java代码发送HTTP请求
        /*
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.声明get请求
        HttpGet httpGet = new HttpGet("https://www.baidu.com/");
        //3.发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //4.判断状态码
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        }else {
            System.out.println("状态码不对，请重新尝试！");
        }
        //5.关闭资源
        response.close();
        httpClient.close();
         */
        //目标地址
//        String url = "https://www.baidu.com";
        String url = "http://localhost:8080/b/hello";
        HttpGet httpGet = new HttpGet(url);

        //设置类型
        httpGet.setHeader("Content-Type","application/x-www-form-urlencoded");
        System.out.println("调用URL：" + httpGet.getURI());

        //httpClient实例化
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //执行请求并获取数据返回
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        System.out.println("返回状态码：" + response.getStatusLine());

        //显示结果
        BufferedReader reader = new BufferedReader(new InputStreamReader((entity.getContent()),"UTF-8"));
        String line = null;
        StringBuffer responseSB = new StringBuffer();
        while((line = reader.readLine()) != null){
            responseSB.append(line);
        }
        System.out.println("返回消息：" + responseSB);

        reader.close();
        httpClient.close();
    }
}
