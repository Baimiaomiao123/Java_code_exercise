package com.baimiaomiao.spring6.test;

import com.baimiaomiao.spring6.bean.Student;
import com.baimiaomiao.spring6.bean.User;
import com.baimiaomiao.spring6.bean.Vip;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className BeanLifeCycleTest
 * @since 1.0
 */


public class BeanLifeCycleTest {

    @Test
    public void testRegisterBean(){
        //自己new的对象
        Student student = new Student();
        System.out.println(student);

        //将以上自己new的这个对象纳入Spring容器来管理，半路上交给Spring来管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean",student);

        //从spring容器中获取
        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }

    /**
     * spring容器只对singleton的bean进行完整的生命周期管理
     * 如果是prototype作用域的Bean，Spring容器只负责将该Bean初始化完毕，等客户端程序一旦获取到Bean之后，Spring容器就不再管理该对象声明周期
     */
    @Test
    public void testBeanLifeCycle(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        //Vip vip = applicationContext.getBean("vip", Vip.class);
        System.out.println("第四步：使用Bean" + user);

        //注意：必须手动关闭spring容器，这样Spring容器才会销毁Bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }
}
