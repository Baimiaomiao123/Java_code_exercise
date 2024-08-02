package com.baimiaomiao.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className LogAspect
 * @since 1.0
 */

@Component("logAspect")
@Aspect //切面类是需要使用@Aspect注解进行标注的
@Order(2)
public class LogAspect { //切面

    //切面 = 通知 + 切点
    //通知就是增强，就是具体的要编写的增强代码
    //这里通知Advice以方法的形式出现
    //@Before注解标注的方法就是一个前置通知

    /*@Before("execution(* com.baimiaomiao.spring6.service..*(..))")
    public void build(){
        System.out.println("我是一段通知，一段增强代码......");
    }*/

    //定义通用的切点表达式
    @Pointcut("execution(* com.baimiaomiao.spring6.service..*(..))")
    public void generalAspect(){
        //这个方法只是一个标记，方法名随意，方法体中不需要写任何代码
    }

    //前置通知
    @Before("generalAspect()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知......");
        //这个joinPoint，在Spring容器调用这个方法的时候自动传过来
        //我们可以直接用，用这个干啥？
        //Signature signature = joinPoint.getSignature(); 获取目标方法的签名
        //通过方法的签名可以获取到一个方法的具体信息
        System.out.println("目标方法的方法名：" + joinPoint.getSignature().getName());

    }

    //后置通知
    @AfterReturning("generalAspect()")
    public void afterReturningAdvice(){
        System.out.println("后置通知......");
    }

    //环绕通知(环绕是最大的通知，在前置通知之前。在后置通知之后)
    @Around("execution(* com.baimiaomiao.spring6.service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //前面的代码
        System.out.println("前环绕...");
        //执行目标
        joinPoint.proceed();
        //后面的代码
        System.out.println("后环绕...");
    }

    //异常通知
    @AfterThrowing("execution(* com.baimiaomiao.spring6.service..*(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知......");
    }

    //最终通知
    @After("execution(* com.baimiaomiao.spring6.service..*(..))")
    public void afterAdvice(){
        System.out.println("最终通知......");
    }
}
