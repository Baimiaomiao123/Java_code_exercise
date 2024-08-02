package com.baimiaomiao.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className TestController
 * @since 1.0
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/testError")
    public String testError(){
        System.out.println(1/0);
        return "success";
    }

}
