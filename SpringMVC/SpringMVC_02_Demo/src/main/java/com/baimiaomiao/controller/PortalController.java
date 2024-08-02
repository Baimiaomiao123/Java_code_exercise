package com.baimiaomiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className PortalController
 * @since 1.0
 */

@Controller
public class PortalController {
    /*由于没有业务代码，所以可以直接在springmvc中的mvc:view-controller标签中直接配置*/
    /*@RequestMapping("/")
    public String protal(){
        return "index";
    }*/

    /*@RequestMapping({"/hello","/abc"})
    public String hello(){
        return "success";
    }*/

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }
}
