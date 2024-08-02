package org.baimiaomiao.service;

import org.baimiaomiao.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderService
 * @since 1.0
 */

@Service("orderService")
public class OrderService {

    //@Autowired使用的时候不需要指定任何属性，直接使用即可
    //这个注解的作用是根据类型byType进行自动装配
    //@Autowired
    //private OrderDao orderDao;

    //如果想解决以上的问题，只需要让其根据名字进行装配即可
    //@Autowired和@Qualifer联合使用，就可以根据名字进行装配
    @Autowired
    //@Qualifier("orderDaoImplForOracle") //注入Oracle数据库
    @Qualifier("orderDaoImplForMySQL") //注入MySQL数据库
    private OrderDao orderDao;

    //注解还可以出现在set方法上、构造方法上、参数上
    //一个类当中构造方法只有一个，并且构造方法上的参数和属性能够对应上，@Autowired注解可以省略

    public void generate(){
        orderDao.insert();
    }
}
