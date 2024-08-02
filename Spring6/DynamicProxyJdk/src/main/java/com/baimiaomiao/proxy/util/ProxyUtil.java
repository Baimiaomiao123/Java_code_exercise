package com.baimiaomiao.proxy.util;

import com.baimiaomiao.proxy.service.OrderService;
import com.baimiaomiao.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className ProxyUtil
 * @since 1.0
 */


public class ProxyUtil {

    /**
     * 封装一个方法，可以通过这方法获取代理对象
     * @param target
     * @return
     */
    public static Object newProxyInstance(Object target){
        //底层调用的还是JDK的动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));

    }
}
