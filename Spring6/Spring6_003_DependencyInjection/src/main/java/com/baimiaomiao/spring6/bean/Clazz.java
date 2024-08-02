package com.baimiaomiao.spring6.bean;

/**
 * 表示班级
 * @author baimiaomiao
 * @version 1.0
 * @className Clazz
 * @since 1.0
 */


public class Clazz {
    //班级名称
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }
}
