package com.baimiaomiao.spring6.bean;

/**
 * 这是一个bean，封装了用户的信息，Spring可以帮我们创建User对象
 * @author baimiaomiao
 * @version 1.0
 * @className User
 * @since 1.0
 */


public class User {

    //Spring是怎么实例化对象？
    //默认情况下Spring会通过反射机制，调用类的无参数构造方式创建对象
    //实现原理如下：
    // Class clazz = Class.forName("com.baimiaomiao.spring6.bean.User");
    //Object obj = clazz.newInstance();
    public User(){
        System.out.println("User的无参数构造方法执行......");
    }

    //如果只在这里写了有参数构造方法，没有重写无参构造方法，就会报错
    public User(String s){

    }
}
