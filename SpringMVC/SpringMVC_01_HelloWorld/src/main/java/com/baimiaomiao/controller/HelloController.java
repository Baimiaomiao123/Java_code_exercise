package com.baimiaomiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className HelloController
 * @since 1.0
 */

@Controller
public class HelloController {

    @RequestMapping("/")
    public String portal(){
        System.out.println("portal方法调用");
        //将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello World!");
        return "success";
    }

}
