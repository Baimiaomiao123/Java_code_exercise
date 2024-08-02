package com.baimiaomiao.controller;

import com.baimiaomiao.pojo.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className TestParamController
 * @since 1.0
 */

/*
    获取请求参数的方式：
        1、通过servletAPI获取
            只需要在控制器方法的形参位置设置HttpServletRequest类型的形参，就可以通过request获取请求参数
        2、通过控制器方法的形参获取
            只需要在控制器方法的形参位置设置一个形参，这个形参需要和请求参数的名字一致即可
        3、RequestParam:将请求参数和空气值方法的形参绑定
            三个属性：
                value:设置和形参绑定的请求参数的名字
                required:设置是否必须传输value所对应的请求参数，默认为true表示value所对应的参数必须传输，否则页面报错400 - Required String parameter 'xxx' is not present
                        若设置为false，则表示value所对应的请求参数不是必须传输，若为传输，则形参值为null
                defaultValue:设置当没有传输value所对应的请求参数时，为形参设置的默认值，此时和required属性值无关
        4、@RequestHeader：将请求头信息和控制器方法的形参绑定（参数类似于RequestParam）
        5、@CookieValue，将Cookie数据和控制器方法的形参绑定（参数类似于RequestParam）
        6、通过控制器方法的实体类型的形参获取请求参数
            需要在控制器方法的形参位置设置实体类型的形参，要保证实体类中的属性名和请求参数的名字一致
            然后就可以通过实体类的属性获取请求参数
 */
@Controller
@RequestMapping("/param")
public class TestParamController {

    @RequestMapping(value = "/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request,HttpSession mySession){
        HttpSession session = request.getSession();

        //使用ServletAPI向request域中共享数据（还有其他方式，这钟方式不常用，其他见TestScopeController）
        request.setAttribute("testRequestScope","Hello, ServletAPI");

        //向session域中共享数据（建议方式）
        mySession.setAttribute("testSessionScope","Hello, ServletAPI");
        //向application域中共享数据
        ServletContext servletContext = mySession.getServletContext();
        servletContext.setAttribute("testApplicationScope","Hello ServletAPI");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username=" + username + ",password=" + password);
        return "success";
    }

    @RequestMapping("")
    public String getParam(@RequestParam(value = "username",required = false,defaultValue = "admin") String userName,
                           String password,
                           @RequestHeader(value = "referer") String referer, //参数类似于@RequestParam
                           @CookieValue("JSESSIONID") String jsessionID
    ){
        System.out.println("username=" + userName + ",password=" + password);
        System.out.println("referer=" + referer);
        System.out.println("jsessionID=" + jsessionID);
        return "success";
    }

    @RequestMapping("/pojo")
    public String getParamByPojo(User user){
        System.out.println(user); //属性名一定要与请求参数名一致才行！！！
        return "success";
    }

}
