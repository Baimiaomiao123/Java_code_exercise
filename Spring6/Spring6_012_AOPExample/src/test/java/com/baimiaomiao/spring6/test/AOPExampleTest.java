package com.baimiaomiao.spring6.test;

import com.baimiaomiao.spring6.biz.UserService;
import com.baimiaomiao.spring6.biz.VipService;
import com.baimiaomiao.spring6.service.AccountService;
import com.baimiaomiao.spring6.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className AOPExampleTest
 * @since 1.0
 */


public class AOPExampleTest {

    @Test
    public void testSecurityLog(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.saveUser();
        userService.deleteUser();
        userService.updateUser();
        userService.getUser();

        VipService vipService = applicationContext.getBean("vipService", VipService.class);
        vipService.saveVip();
        vipService.deleteVip();
        vipService.updateVip();
        vipService.getVip();
    }

    @Test
    public void testTransaction(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
        orderService.cancel();

        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer();
        accountService.withdraw();
    }
}
