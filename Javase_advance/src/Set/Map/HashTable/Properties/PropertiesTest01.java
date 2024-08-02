package Set.Map.HashTable.Properties;

/*
    目前只需要掌握Properties属性类对象的相关方法即可
    Properties是一个Map集合，继承Hashtable。Properties的key和value都是String类型
    Properties被称为属性类对象
    Properties是线程安全的
 */

import java.util.Properties;

public class PropertiesTest01 {
    public static void main(String[] args) {
        //创建一个Properties对象
        Properties pro = new Properties();

        //需要掌握Properties的两个方法，一个存，一个取
        //setProperties和getProperties方法
        pro.setProperty("url","jdbc:mysql://localhost:3306/bjpowernode");
        pro.setProperty("diver","com.mysql.jdbc.Driver");
        pro.setProperty("username","root");
        pro.setProperty("password","123");

        //通过key来获取value
        String s1 = pro.getProperty("url");
        String s2 = pro.getProperty("driver");
        String s3 = pro.getProperty("username");
        String s4 = pro.getProperty("password");

        System.out.println(s1+" "+s2+" "+s3+" "+s4);

    }
}
