package com.baimiaomiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderHystrixMain80
 * @since 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Feign
@EnableHystrix //开启hystrix
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }

}
