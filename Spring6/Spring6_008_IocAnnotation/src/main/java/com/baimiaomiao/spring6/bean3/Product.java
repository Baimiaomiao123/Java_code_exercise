package com.baimiaomiao.spring6.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className User
 * @since 1.0
 */


@Component
public class Product {

//    @Value("zhangsan")
//    private String name;
//    @Value("30")
//    private int age;


    private String name;
    private int age;

    //Value注解也可以使用在方法上
//    @Value("zhangsan")
//    public void setName(String name) {
//        this.name = name;
//    }
//    @Value("30")
//    public void setAge(int age) {
//        this.age = age;
//    }

    //也可以加到参数构造方法的形式参数上
    public Product(@Value("zhangsan")String name, @Value("30")int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
