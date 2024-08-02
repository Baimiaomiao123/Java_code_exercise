package Reflect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
    验证反射机制的灵活性:
        java代码写一遍，再不改变java源代码的基础上，可以做到不同对象的实例化
        所以非常灵活。（符合OCP开闭原则：对扩展开放，对修改关闭）

    后期要学习的是高级框架，而工作过程中，也都是使用高级框架
    包括：ssh ssm
        Spring SpringMVC MyBatis
        Spring Struts Hibernate
        ...
        这些高级框架的底层实现原理：都采用了反射机制，所以反射机制还是很重要的
        学会了反射机制有利于理解剖析框架底层的源代码
 */
public class ReflectTest03 {
    public static void main(String[] args) {
        //这种方式代码就写死了，只能创建一个User类型的对象
        User user = new User();

        //以下代码是灵活的，代码不需要改动，可以修改配置文件，配置文件修改之后，可以创建出不同的实例对象
        //通过IO流读取classinfo.properties文件
        FileReader reader = null;
        try {
            reader = new FileReader("javase_advance/src/Reflect/classinfo.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //创建属性类对象
        Properties pro = new Properties();

        //将文件加载到属性类对象中
        try {
            pro.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //数据已经加载完毕，可以关闭流了
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //通过属性流对象的getProperty()方法：通过key获取value
        String className = pro.getProperty("className");
        System.out.println(className);

        //通过反射机制实例化对象
        Class c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Object obj = null;
        try {
            obj = c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(obj);

    }
}
