package com.baimiaomiao.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Person
 * @since 1.0
 */


public class Person {
    //注入List集合
    private List<String> names;

    //注入Set集合
    private Set<String> addrs;

    //注入Map集合
    private Map<Integer,String> phones;

    //注入属性类对象
    //Properties本质上也是一个Map集合
    //Properties父类Hashtable，Hashtable实现了Map集合
    //虽然这个也是一个Map集合，但是Map的注入方式有点像，但是不同
    //Properties的key和value只能是String类型
    private Properties properties;

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addrs=" + addrs +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

}
