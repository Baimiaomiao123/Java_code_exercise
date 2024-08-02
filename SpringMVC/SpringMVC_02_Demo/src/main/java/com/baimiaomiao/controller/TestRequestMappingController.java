package com.baimiaomiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className TestRequestMappingController
 * @since 1.0
 */


/*
    @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
    @RequestMapping标识一个方法：设置映射请求请求的路径的具体信息

    @RequestMapping注解value属性
        作用：通过请求的请求路径匹配请求
        value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值，则当前请求就会被注解所标识的方法进行处理

    @RequestMapping注解的method属性
        作用：通过请求的请求方式匹配请求
        method属性是RequestMethod类型的数组，即当前浏览器所发送请求的请求方式匹配method属性中的任何一个请求方式
        若发送的请求的请求路径与@RequestMapping注解value属性匹配，但是请求方式不匹配就会报错：405 - Method 'GET/POST/XXX' is not supported.
        在@RequestMapping的基础上，结合请求方式的一些派生注解：
            @GetMapping,@PostMapping,@DeleteMapping,@PutMapping

    @RequestMapping注解的params属性
        作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
        params可以使用四种表达式
            "param"：表示当前所匹配请求的请求参数中必须携带param参数
            "!param"：表示当前所匹配请求的请求参数中一定不能携带param参数
            "param=value"：表示当前所匹配请求的请求参数中必须携带param参数，且值必须为value
            "param!=value"：表示当前所匹配请求的请求参数中可以不携带param参数，但是若携带值一定不是value
        若发送的请求的请求路径与@RequestMapping注解value属性匹配，请求方式匹配，但是请求参数不满足params的参数要求，就不报错：400 - Invalid request parameters.

    @RequestMapping注解的headers属性
        作用：通过请求的请求头信息匹配请求映射
        headers同样有四种匹配关系
            "header"：要求映射所匹配的请求必须携带header请求头信息
            "!header"：要求映射所匹配的请求必须不携带header请求头信息
            "header=value"：要求映射所匹配的请求必须携带header请求头信息，且请求头的值为value
            "header!=value"：要求映射所匹配的请求不一定携带header请求头信息，如果携带的话请求头的值一定不为value
        若发送的请求的请求路径与@RequestMapping注解value属性匹配，请求方式匹配，但是请求头的值不匹配，报错：404 - Not Found Page



   SpringMVC支持ant风格的路径：
        ?：表示任意的单个字符
        *：表示任意的0个或多个字符
        **：表示任意层数的任意目录
        注意：在使用**的时候，只能使用//xxx的方法

   @RequestMapping注解使用路径中的占位符
        传统：/deleteUser?id=1
        rest：/delete/user/1
        需要在@RequestMapping注解的value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
        然后再通过@PathVariable注解，将占位符所标识的值和控制器方法的形参进行绑定


 */

@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器方法所匹配的请求的请求路径为：/test/hello
    @RequestMapping(
            value = {"/hello","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET},
            params = {"username","!password","age=20","gender!=female"}
    )
    public String hello(){
        return "success";
    }

    @RequestMapping("/hello/a*t")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("id：" + id + ",username：" + username);
        return "success";
    }

}
