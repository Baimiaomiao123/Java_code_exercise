package com.baimiaomiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className HandlerController
 * @since 1.0
 */

@Controller
public class HandlerController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){

        return "success";
    }

}
