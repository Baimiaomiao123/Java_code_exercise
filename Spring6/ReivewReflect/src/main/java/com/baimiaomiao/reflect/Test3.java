package com.baimiaomiao.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Test3
 * @since 1.0
 */


public class Test3 {
    public static void main(String[] args) throws Exception{
        /*
            需求：
                假设现在已知以下信息：
                    1.有这样一个类，类名叫做：com.baimiaomiao.reflect.User
                    2.这个类符合javaBean规范
                    3.你还知道这个类当中有一个属性，属性的名字叫做age
                    4.还知道age属性的类型是int类型
                请使用反射机制调用相关方法给User对象的age属性赋值
         */
        String className = "com.baimiaomiao.reflect.User";
        String propertyName = "age";

        //通过反射机制调用setAge(int)方法
        //获取类
        Class<?> clazz = Class.forName(className);
        //获取方法名字
        String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
        //根据属性名获取属性类型
        Field field = clazz.getDeclaredField(propertyName);
        Class<?> type = field.getType();
        //获取方法
        Method setMethod = clazz.getDeclaredMethod(setMethodName, type);
        //调用方法
        Object obj = clazz.newInstance();
        setMethod.invoke(obj,30);
        System.out.println(obj);
    }
}
