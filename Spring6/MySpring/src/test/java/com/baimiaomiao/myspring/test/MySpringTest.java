package com.baimiaomiao.myspring.test;

import com.baimiaomiao.myspring.bean.UserService;
import com.myspringframework.core.ApplicationContext;
import com.myspringframework.core.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className MySpringTest`
 * @since 1.0
 */


public class MySpringTest {

    @Test
    public void testMySpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
