package com.baimiaomiao.spring6.web;

import com.baimiaomiao.spring6.service.UserService;
import com.baimiaomiao.spring6.service.impl.UserServiceImpl;

/**
 * 表示层
 * @author baimiaomiao
 * @version 1.0
 * @className UserAction
 * @since 1.0
 */

public class UserAction {
    private UserService userService = new UserServiceImpl();

    /**
    删除用户信息的请求
     */
    public void deleteRequest(){
        userService.deleteUser();
    }
}
