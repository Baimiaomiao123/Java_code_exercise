package com.baimiaomiao.springcloud.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderZKController
 * @since 1.0
 */

@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}