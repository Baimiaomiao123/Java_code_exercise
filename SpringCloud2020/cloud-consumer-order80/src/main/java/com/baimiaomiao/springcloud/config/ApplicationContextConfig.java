package com.baimiaomiao.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className ApplicationContextConfig
 * @since 1.0
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力，如果是用用自己写的M有LB实现负载均衡，不能用这一行代码，因为会自动寻找框架的实现类
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

