package com.baimiaomiao.spring6.bean;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className User
 * @since 1.0
 */


public class User {
    private String username; //String是简单类型
    private String password;
    private int age; //int也是简单类型

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
