package com.baimiaomiao.myspring.bean;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className UserService
 * @since 1.0
 */


public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
