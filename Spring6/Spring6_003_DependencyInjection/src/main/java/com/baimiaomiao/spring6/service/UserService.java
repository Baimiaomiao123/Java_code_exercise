package com.baimiaomiao.spring6.service;

import com.baimiaomiao.spring6.dao.UserDao;

/**
 * Bean
 * @author baimiaomiao
 * @version 1.0
 * @className UserService
 * @since 1.0
 */


public class UserService {

    private UserDao userDao;
    //自己写一个set方法：不实用IDEA工具生成，不符合javabean规范
    //至少这个方法是set开始的
    /*public void setMySQLUserDao(UserDao xyz){
        this.userDao = xyz;
    }*/

    //set注入必须提供set方法
    //这个set方法是IDEA工具生成的，符合javaBean规范
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        //保存用户信息到数据库
        userDao.insert();
    }
}
