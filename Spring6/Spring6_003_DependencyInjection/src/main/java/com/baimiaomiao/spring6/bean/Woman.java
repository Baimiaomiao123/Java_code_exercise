package com.baimiaomiao.spring6.bean;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Woman
 * @since 1.0
 */


public class Woman {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                '}';
    }
}
