package com.baimiaomiao.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className SecurityAspect
 * @since 1.0
 */


@Component
@Aspect
@Order(1) //数字越小，优先级越高
public class SecurityAspect { //安全切面

    //通知 + 切面
    @Before("com.baimiaomiao.spring6.service.LogAspect.generalAspect()")
    public void beforeAdvice(){
        System.out.println("前置通知：安全");
    }
}
