package com.baimiaomiao.spring6.service;

import com.baimiaomiao.spring6.dao.UserDao;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className CustomerService
 * @since 1.0
 */


public class CustomerService {

    private UserDao userDao;

    public CustomerService(UserDao userDao) {
        this.userDao = userDao;
    }

    public CustomerService() {
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
