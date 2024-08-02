package com.baimiaomiao.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className FirstInterceptor
 * @since 1.0
 */

@Component
public class FirstInterceptor implements HandlerInterceptor {

    /*
        preHandle：控制器方法执行之前执行该方法，其返回值代表是否需要进行拦截
        postHandle：控制器方法执行之后执行该方法
        afterCompletion：处理完视图和模型数据，渲染视图完毕之后执行该方法
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor-->preHandle");
        //false表示拦截，true表示放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor-->postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor-->afterCompletion");
    }
}
