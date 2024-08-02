package com.baimiaomiao.spring6.biz;

import org.springframework.stereotype.Service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className UserService
 * @since 1.0
 */

@Service
public class UserService {

    public void saveUser(){
        System.out.println("新增用户信息");
    }

    public void deleteUser(){
        System.out.println("删除用户信息");
    }

    public void updateUser(){
        System.out.println("修改用户信息");
    }

    public void getUser(){
        System.out.println("查找用户信息");
    }
}
