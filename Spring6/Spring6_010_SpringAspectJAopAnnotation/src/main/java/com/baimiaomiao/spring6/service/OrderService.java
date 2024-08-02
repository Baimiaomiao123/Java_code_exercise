package com.baimiaomiao.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderService
 * @since 1.0
 */

@Service("orderService")
public class OrderService { //目标类

    public void generate(){ //目标方法
        System.out.println("生成订单......");
        /*if (1 == 1){
            throw new RuntimeException("运行时异常");
        }*/
    }
}
