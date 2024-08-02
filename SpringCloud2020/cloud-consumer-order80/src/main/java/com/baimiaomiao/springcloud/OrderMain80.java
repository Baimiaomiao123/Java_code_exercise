package com.baimiaomiao.springcloud;

import com.baimiaomiao.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className OrderMain80
 * @since 1.0
 */

@SpringBootApplication
//替换负载均衡算法
@LoadBalancerClient(value = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}
