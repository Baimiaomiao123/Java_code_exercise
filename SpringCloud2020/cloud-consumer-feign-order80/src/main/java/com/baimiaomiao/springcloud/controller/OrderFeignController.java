package com.baimiaomiao.springcloud.controller;

import com.baimiaomiao.springcloud.entities.CommonResult;
import com.baimiaomiao.springcloud.entities.Payment;
import com.baimiaomiao.springcloud.service.PaymentFeignService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderFeignController
 * @since 1.0
 */

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon，客户端一般默认等待一秒
        return paymentFeignService.paymentFeignTimeout();
    }

}
