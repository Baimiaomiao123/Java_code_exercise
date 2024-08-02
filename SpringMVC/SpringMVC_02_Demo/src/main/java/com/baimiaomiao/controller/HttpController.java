package com.baimiaomiao.controller;

import com.baimiaomiao.pojo.Custom;
import com.baimiaomiao.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className HttpController
 * @since 1.0
 */


@Controller
//@RestController //该注解是SpringMVC提供的一个复合注解，表示在控制器的类上，相当于为类添加了@Controller注解，并且为其中的每个方法添加了@ResponseBody注解
public class HttpController {

    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody：" + requestBody); //requestBody：username=admin&password=123456
        return "success";
    }

    @RequestMapping(value = "/testRequestEntity",method = RequestMethod.POST)
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //当前requestEntity表示整个请求报文的信息
        System.out.println("RequestHeader：" + requestEntity.getHeaders());
        System.out.println("RequestBody：" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello, Response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/testResponseCustom")
    @ResponseBody
    public Custom testResponseCustom(){
        return new Custom(1001,"admin","123456",23,"男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password){
        System.out.println(username + "," + password);
        return "hello, axios";
    }

}
