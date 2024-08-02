package com.baimiaomiao.proxy.client;

import com.baimiaomiao.proxy.service.OrderService;
import com.baimiaomiao.proxy.service.OrderServiceImpl;
import com.baimiaomiao.proxy.service.OrderServiceImplSub;
import com.baimiaomiao.proxy.service.OrderServiceProxy;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Test
 * @since 1.0
 */


public class Test {
    public static void main(String[] args) {
        /*OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.modify();
        orderService.detail();*/

        /*OrderService orderService = new OrderServiceImplSub();
        orderService.generate();
        orderService.modify();
        orderService.detail();*/

        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        OrderServiceProxy proxy = new OrderServiceProxy(target);
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
