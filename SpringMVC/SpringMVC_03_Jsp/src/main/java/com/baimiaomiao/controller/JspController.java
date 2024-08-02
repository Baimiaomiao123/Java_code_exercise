package com.baimiaomiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className JspController
 * @since 1.0
 */

@Controller
public class JspController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
