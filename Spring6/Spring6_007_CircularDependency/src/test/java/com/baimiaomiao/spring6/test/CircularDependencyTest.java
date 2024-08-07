package com.baimiaomiao.spring6.test;

import com.baimiaomiao.spring6.bean.Husband;
import com.baimiaomiao.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className CircularDependencyTest
 * @since 1.0
 */


public class CircularDependencyTest {

    @Test
    public void testCD2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Husband husbandBean = applicationContext.getBean("h", Husband.class);
        Wife wifeBean = applicationContext.getBean("w", Wife.class);

        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }

    @Test
    public void testCD(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);

        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }
}
