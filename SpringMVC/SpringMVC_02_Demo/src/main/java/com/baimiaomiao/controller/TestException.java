package com.baimiaomiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className TestException
 * @since 1.0
 */

@Controller
public class TestException {

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){
        //模拟数学运算异常以跳转到error页面
        System.out.println(1/0);
        return "success";
    }

}
