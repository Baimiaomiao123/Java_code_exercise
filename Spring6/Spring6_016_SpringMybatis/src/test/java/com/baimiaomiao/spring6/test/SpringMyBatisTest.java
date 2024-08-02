package com.baimiaomiao.spring6.test;

import com.baimiaomiao.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className SpringMyBatisTest
 * @since 1.0
 */


public class SpringMyBatisTest {

    @Test
    public void testSM(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try{
            accountService.transfer("act-001","act-002",10000.0);
            System.out.println("转账成功！");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
