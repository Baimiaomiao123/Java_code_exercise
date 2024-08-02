package com.baimiaomiao.spring6.service.impl;

import com.baimiaomiao.spring6.dao.UserDao;
import com.baimiaomiao.spring6.dao.impl.UserDaoImplForMySQL;
import com.baimiaomiao.spring6.dao.impl.UserDaoImplForOracle;
import com.baimiaomiao.spring6.service.UserService;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className UserServiceImpl
 * @since 1.0
 */

public class UserServiceImpl implements UserService {

    //UserDao userDao = new UserDaoImplForMySQL();

    //修改为
    //UserDao userDao = new UserDaoImplForOracle();

    //真正的面向接口编程
    private UserDao userDao;

    @Override
    public void deleteUser() {
        // 删除业务信息的业务逻辑
        userDao.deleteById();
    }

}
