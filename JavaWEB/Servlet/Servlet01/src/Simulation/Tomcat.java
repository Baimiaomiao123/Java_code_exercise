package Simulation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


//充当Tomcat服务器开发者
public class Tomcat {

    public static void main(String[] args) {
        System.out.println("Tomcat服务器启动成功，开始接受用户的访问");

        //简单的使用Scanner模拟一下用户的请求
        //用户访问服务器是通过浏览器上的"请求路径"
        //也就是说用户的路径不同，后台执行的Servlet不同
        System.out.println("请输入您的访问路径：");
        Scanner s = new Scanner(System.in);

        //用户的请求路径
        String path = s.nextLine(); //Tomcat服务器已经获取到了用户的请求路径

        // Tomcat服务器应该通过用户的请求路径找对应的XXXServlet
        //请求路径和XXXServlet之间的关系应该由谁指定呢？
        //对于Tomcat服务器来说需要解析配置文件
        FileReader reader = null;
        try {
            reader = new FileReader("/Users/miaopeng/code/java/code_exercise/JavaWEB/Servelet/src/Simulation/web.properties");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties pro = new Properties();
        try {
            pro.load(reader);
//            将配置文件内容显示在控制台
//            pro.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过key获取value
        String className = pro.getProperty(path);
        //通过反射机制创建对象
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //但是Tomcat服务器的开发者知道，你写的Servlet一定实现了Servlet接口
        servlet servlet = (Simulation.servlet) obj;
        servlet.service();



    }
}
