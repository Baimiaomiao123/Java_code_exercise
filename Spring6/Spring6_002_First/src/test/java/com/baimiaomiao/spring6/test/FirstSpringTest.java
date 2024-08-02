package com.baimiaomiao.spring6.test;

import com.baimiaomiao.spring6.bean.User;
import com.baimiaomiao.spring6.dao.UserDaoImplForMySQL;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author baimiaomiao
 * @version 1.0
 * @className FirstSpringTest
 * @since 1.0
 */


public class FirstSpringTest {

    @Test
    public void testBeginInitBean(){
        //注意：不实在调用getBean方法的时候创建对象，在解析的时候就会实例化就会创建对象
        new ClassPathXmlApplicationContext("spring.xml");

        //自己怎么用log4j2记录日志信息呢？
        //第一步：创建日志记录器对象
        //获取FirstSpringTest类的日志记录器对象，也就是说只要是这个类中的代码执行记录日志的话，就输出相关的日志信息
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

        //第二步：记录日志，根据不同的级别来输出日志
        logger.info("我是一条消息");
        logger.debug("我是一条调试信息");
        logger.error("我是一条错误信息");
    }

    @Test
    public void testBeanFactory(){
        // ApplicationContext接口的超级父接口是：BeanFactory（翻译为Bean工厂，就是能够生产Bean对象的一个工厂对象）
        // BeanFactory是IoC容器的顶级接口
        // Spring的IoC容器底层使用了：工厂模式
        // Spring底层的IoC是怎么实现的？ XML解析 + 工厂模式 + 反射机制
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testXmlPath(){
        //FileSystemXmlApplicationContext 不是从类的根路径中加载
        //这种方式很少用，移植性差
        //这里使用绝对路径必须在最前面加file://
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("file:///Users/miaopeng/code/java/code_exercise/Spring6/Spring6_002_First/src/main/resources/com/beans.xml");
        User userBean2 = applicationContext.getBean("userBean3", User.class);
        System.out.println(userBean2);
    }

    @Test
    public void testFirstSpringCode(){
        // 第一步：获取Spring容器对象
        // ApplicationContext 翻译为：应用上下文。其实就是Spring容器
        // ApplicationContext 是一个接口
        // ApplicationContext 接口有很多实现类，其中有一个实现类是ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext 专门从类路径当中加载spring配置文件的一个Spring上下文对象
        // 这行代码只要执行，就相当于启动了Spring容器。解析spring.xml文件，并且实例化所有bean对象，放到spring容器当中
        // 也可以配置多个文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml","beans.xml","com/beans.xml");


        // 第二步：根据bean的id从Spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        //Object userDaoBean = applicationContext.getBean("userDaoBean");
        UserDaoImplForMySQL userDaoBean = applicationContext.getBean("userDaoBean", UserDaoImplForMySQL.class);
        userDaoBean.insert();
        System.out.println(userDaoBean);

        Object vipBean = applicationContext.getBean("vipBean");
        System.out.println(vipBean);

        Object userBean2 = applicationContext.getBean("userBean2");
        System.out.println(userBean2);

        //Date nowTime = (Date) applicationContext.getBean("nowTime");
        //不想强制类型转换，可以使用以下方法（通过第二个参数来指定类型）
        Date nowTime = applicationContext.getBean("nowTime", Date.class);

        //如果id写错，不会出现null，而是会报错
        //Object nowTime = applicationContext.getBean("nowTime");
        //System.out.println(nowTime);
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strNow = sdf.format(nowTime);
        System.out.println(strNow);


    }
}
