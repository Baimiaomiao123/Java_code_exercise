package com.baimiaomiao.spring6.dao.impl;

import com.baimiaomiao.spring6.dao.UserDao;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className UserDaoImplForMySQL
 * @since 1.0
 */


public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据正在删除用户信息......");
    }
}
