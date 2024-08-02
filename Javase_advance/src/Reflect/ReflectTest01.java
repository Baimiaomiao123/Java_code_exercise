package Reflect;

import java.util.Date;

/*
    要操作一个类的字节码，首先需要获取到这个类的字节码，怎么获取java.lang.Class实例？
        三种方式
            第一种：Class c = Class.forName("完整类名带包名")
            第二种：Class c = 引用/对象.getClass();
            第三种：Class c = 任何类型.class;

 */
public class ReflectTest01 {
    public static void main(String[] args) {

        /*
            Class.forName()
                1、静态方法
                2、方法的参数是一个字符串
                3、字符串需要是一个完整类名
                4、完整类名必须带有包名
         */
        Class c1 = null;
        try {
            c1 = Class.forName("java.lang.String"); //c1代表String.class文件
            Class c2 = Class.forName("java.util.Date"); //c2代表Date.class文件
            Class c3 = Class.forName("java.lang.Integer");  //c3代表Integer.class文件
            Class c4 = Class.forName("java.lang.System");   //c4代表System.class文件
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //第二种方式：java中任何一个对象都有一个方法：getClass()
        String s = "abc";
        Class x = s.getClass(); //x代表String.class字节码文件，x代表String类型
        System.out.println(x == c1); //true，表示c1的内存地址和x的内存地址相同。（因为c1和x都是代表的String类型）

        //第三种方式：java语言中任何一种类型，包括基本数据类型，它都有.class属性
        Class z = String.class;
        Class k = Date.class;
        Class f = int.class;
        Class c = double.class;
    }
}
