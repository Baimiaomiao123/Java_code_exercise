package com.baimiaomiao.spring6.test;

import cn.baimiaomiao.Spring6Config;
import cn.baimiaomiao.service.StudentService;
import com.baimiaomiao.spring6.bean.*;
import com.baimiaomiao.spring6.bean3.MyDataSource;
import com.baimiaomiao.spring6.bean3.Product;
import com.baimiaomiao.spring6.dao.OrderDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className IoCAnnotationTest
 * @since 1.0
 */


public class IoCAnnotationTest {

    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentService studentService = annotationConfigApplicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

    @Test
    public void testResource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

    @Test
    public void testAutowired(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        org.baimiaomiao.service.OrderService orderService = applicationContext.getBean("orderService", org.baimiaomiao.service.OrderService.class);
        orderService.generate();
    }

    @Test
    public void testDIByAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);

        Product product = applicationContext.getBean("product", Product.class);
        System.out.println(product);
    }

    @Test
    public void testChoose(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");
    }

    @Test
    public void testBeanComponent(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        System.out.println(orderBean);
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
        Student studentBean = applicationContext.getBean("student", Student.class);
        System.out.println(studentBean);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        System.out.println(orderService);

        OrderDao orderDao = applicationContext.getBean("orderDao", OrderDao.class);
        System.out.println(orderDao);

    }
}
