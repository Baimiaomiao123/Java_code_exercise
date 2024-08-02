package com.baimiaomiao.spring6.test;

import com.baimiaomiao.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className SpringBeanScopeTest
 * @since 1.0
 */


public class SpringBeanScopeTest {

    @Test
    public void testBeanScope(){
        /*
            1.Spring默认情况下，是如何管理Bean的？
                默认情况下，Bean是单例(singleton)的，在Spring上下文初始化的时候实例化
                每一次调用getBean()方法的时候，都是返回哪个单例的对象
            2.当将Bean的scope属性设置为prototype的时候：
                bean是多例的
                Spring上下文初始化的时候，并不会初始化这些prototype的bean
                每一次调用getBean()方法的时候，实例化该对象
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean springBean1 = applicationContext.getBean("springBean", SpringBean.class);
        SpringBean springBean2 = applicationContext.getBean("springBean", SpringBean.class);
        SpringBean springBean3 = applicationContext.getBean("springBean", SpringBean.class);
        //单例模式
        System.out.println(springBean1);
        System.out.println(springBean2);
        System.out.println(springBean3);
    }
}
