package com.baimiaomiao.junit.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * 单元测试类
 * @author baimiaomiao
 * @version 1.0
 * @since 1.0
 */
public class MathServiceTest { //名字规范——类名+Test

    //单元测试的方法写多少个？
    //一般是一个业务方法对应一个测试方法
    //测试方法的规范：public void testXxx(){}
    //测试方法的方法名：以test开始，假设测试呃方法是sum，这个测试方法名：testSum
    //@Test非常重要，被这个注解标识的就是测试方法
    @Test
    public void testSum(){
        //单元测试中有两个重要的概念：
        //一个是实际值，一个是期望值
        MathService mathService = new MathService();

        //实际值
        int res = mathService.sum(1,2);
        int res2 = mathService.sum(10,20);

        //加断言进行测试
        Assert.assertEquals(3,res);
        Assert.assertEquals(30,res2);
    }

    @Test
    public void testSub(){
        MathService mathService = new MathService();
        int res = mathService.sub(19,9);
        Assert.assertEquals(10,res);
    }
}
