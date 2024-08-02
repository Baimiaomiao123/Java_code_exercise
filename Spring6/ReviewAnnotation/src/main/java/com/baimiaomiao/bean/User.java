package com.baimiaomiao.bean;

import com.baimiaomiao.annotation.Component;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className User
 * @since 1.0
 */

@Component("userBean")
public class User {

    //编译器报错，不能出现在这里
    //@Component(value = "test")
    private String name;
}
