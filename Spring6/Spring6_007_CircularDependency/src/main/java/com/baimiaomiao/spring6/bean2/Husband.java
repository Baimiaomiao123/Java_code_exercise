package com.baimiaomiao.spring6.bean2;

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

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
