package com.baimiaomiao.reflect;

import java.lang.reflect.Method;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Test2
 * @since 1.0
 */


public class Test2 {
    public static void main(String[] args) throws Exception {
        // 使用反射机制来调用方法
        // 获取类
        Class<?> clazz = Class.forName("com.baimiaomiao.reflect.SomeService");

        //获取方法
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);;

        //调用方法
        //四要素：调用哪个对象，哪个方法，传什么参数，返回什么值
        //obj——哪个对象
        //doSomeMethod——哪个方法
        //"李四", 250——什么参数
        //retValue——返回值
        Object obj = clazz.newInstance();
        Object retValue = doSomeMethod.invoke(obj, "李四", 250);
        System.out.println(retValue);
    }
}
