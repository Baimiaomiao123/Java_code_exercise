package com.baimiaomiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderFeignMain80
 * @since 1.0
 */

@SpringBootApplication
@EnableFeignClients //使用Feign的开关
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }

}
