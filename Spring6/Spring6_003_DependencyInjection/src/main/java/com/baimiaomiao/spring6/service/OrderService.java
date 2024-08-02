package com.baimiaomiao.spring6.service;

import com.baimiaomiao.spring6.dao.OrderDao;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderService
 * @since 1.0
 */


public class OrderService {

    private OrderDao orderDao;

    //通过set方法给属性赋值
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.insert();
    }
}
