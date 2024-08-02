package com.baimiaomiao.springcloud.controller;

import com.baimiaomiao.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderHystrixController
 * @since 1.0
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);

    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="1500")
//    })
//    将以上的服务降级统一配置到service的PaymentFallbackService类中
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        //int age = 10 / 0;
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费端80，对方支付系统繁忙请10秒钟后再试或运行出错！呜呜";
    }

    //global fallback method
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，呜呜";
    }

}
