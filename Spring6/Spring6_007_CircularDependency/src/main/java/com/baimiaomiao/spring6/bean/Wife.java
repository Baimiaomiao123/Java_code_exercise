package com.baimiaomiao.spring6.bean;

/**
 * 妻子类
 * @author baimiaomiao
 * @version 1.0
 * @className Wife
 * @since 1.0
 */


public class Wife {
    private String name;
    private Husband husband;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
