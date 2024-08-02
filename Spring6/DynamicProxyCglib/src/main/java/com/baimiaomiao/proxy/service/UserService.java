package com.baimiaomiao.proxy.service;

/**
 * 目标类
 * @author baimiaomiao
 * @version 1.0
 * @className UserService
 * @since 1.0
 */


public class UserService {

    //目标方法
    public boolean login(String username,String password){
        System.out.println("系统正在验证身份......");
        if("admin".equals(username) && "123".equals(password)){
            return true;
        }

        return false;
    }

    public void logout(){
        System.out.println("系统正在退出......");
    }
}
