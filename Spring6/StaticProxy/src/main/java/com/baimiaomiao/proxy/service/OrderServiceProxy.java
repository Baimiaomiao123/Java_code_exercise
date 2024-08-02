package com.baimiaomiao.proxy.service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderServiceProxy
 * @since 1.0
 */

//代理对象（代理对象和目标对象需要实现相同的公共接口）
public class OrderServiceProxy implements OrderService{

    //将目标对象作为代理对象的一个属性，这种关系叫做关联关系，这种关系的耦合度比继承的关系低
    //注意：这里要写一个公共接口类型。因为耦合度低
    private OrderService target; //目标对象，目标对象一定实现了OrderService接口的方法

    //创建代理对象的时候，传一个目标对象给代理对象
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() { //代理方法
        //增强
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() { //代理方法
        //增强
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() { //代理方法
        //增强
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

}
