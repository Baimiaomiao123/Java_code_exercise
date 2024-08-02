package com.baimiaomiao.spring6.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className SecurityLogAspect
 * @since 1.0
 */

@Component
@Aspect
public class SecurityLogAspect {

    @Pointcut("execution(* com.baimiaomiao.spring6.biz..save*(..))")
    public void savePointCut(){}

    @Pointcut("execution(* com.baimiaomiao.spring6.biz..delete*(..))")
    public void deletePointCut(){}

    @Pointcut("execution(* com.baimiaomiao.spring6.biz..update*(..))")
    public void updatePointCut(){}

    @Pointcut("execution(* com.baimiaomiao.spring6.biz..get*(..))")
    public void getPointCut(){}


    @Before("savePointCut() || deletePointCut() || updatePointCut()")
    public void beforeAdvice(JoinPoint joinPoint){
        //获取系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTime = sdf.format(new Date());

        //输出日志信息
        System.out.println(nowTime + " zhangsan : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

}
