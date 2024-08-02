package com.baimiaomiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className TestScopeController
 * @since 1.0
 */

/*
    向域对象共享数据：
        1、使用ModelAndView向请求域共享数据
            使用ModelAndView时，Model：向请求域中共享数据，View：设置逻辑视图，实现页面跳转
            但是控制器方法一定将ModelAndView作为方法的返回值
        2、使用Model向请求域共享数据
        3、使用ModelMap向请求域共享数据
        4、使用map向请求域共享数据
        5、Model、ModelMap、Map的关系
            其实在底层中，这些类型的形参最终都是通过BindingAwareModelMap创建
            public class BindingAwareModelMap extends ExtendedModelMap {}
            public class ExtendedModelMap extends ModelMap implements Model {}
            public class ModelMap extends LinkedHashMap<String, Object> {}
            public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {}
 */

@Controller
@RequestMapping("/scope")
public class TestScopeController {

    /**
     * ModelAndView包含Model和View的功能
     * Model：向请求域中共享数据
     * View：设置逻辑视图，实现页面跳转
     */
    @RequestMapping("/mav")
    public ModelAndView testMAV(){
        ModelAndView mav = new ModelAndView(); //org.springframework.validation.support.BindingAwareModelMap
        //向请求域中共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置逻辑视图，实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/model")
    public String testModel(Model model){
        System.out.println(model.getClass().getName()); //org.springframework.validation.support.BindingAwareModelMap
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }

    @RequestMapping("/modelMap")
    public String testModelMap(ModelMap modelMap){
        System.out.println(modelMap.getClass().getName()); //org.springframework.validation.support.BindingAwareModelMap
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        return "success";
    }

    @RequestMapping("/map")
    public String testMap(Map<String,Object> map){
        System.out.println(map.getClass().getName());
        map.put("testRequestScope","hello,Map");
        return "success";
    }

    @RequestMapping("/application")
    public String testSession(){

        return "success";
    }

}
