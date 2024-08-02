package com.baimiaomiao.proxy.service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderServiceImpl
 * @since 1.0
 */


public class OrderServiceImpl implements OrderService{ //目标对象


    @Override
    public String getName() {
        System.out.println("getName()方法执行......");
        return "zhangsan";
    }

    @Override
    public void generate() { //目标方法
        //模拟生成订单的耗时
        try {
            Thread.sleep(2234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
    }

    @Override
    public void modify() { //目标方法
        //模拟修改订单的耗时
        try {
            Thread.sleep(2234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
    }

    @Override
    public void detail() { //目标方法
        //查询订单的耗时
        try {
            Thread.sleep(2234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请看订单详情");
    }
}
