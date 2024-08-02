package com.baimiaomiao.spring6.bean;

/**
 * 丈夫类
 * @author baimiaomiao
 * @version 1.0
 * @className Husband
 * @since 1.0
 */


public class Husband {
    private String name;
    private Wife wife;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
