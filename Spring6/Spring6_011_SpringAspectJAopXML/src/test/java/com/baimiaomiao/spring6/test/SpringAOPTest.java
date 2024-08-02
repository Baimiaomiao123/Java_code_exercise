package com.baimiaomiao.spring6.test;

import com.baimiaomiao.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className SpringAOPTest
 * @since 1.0
 */


public class SpringAOPTest {

    @Test
    public void testXML(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.logout();
    }
}
