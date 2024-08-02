package com.baimiaomiao.spring6.bean;

import java.util.Date;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Dog
 * @since 1.0
 */


public class Dog {
    //简单类型
    private String name;
    private int age;

    //非简单类型
    private Date birth;

    //p空间命名注入底层还是set注入，只不过命名能够让spring配置更简单
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
