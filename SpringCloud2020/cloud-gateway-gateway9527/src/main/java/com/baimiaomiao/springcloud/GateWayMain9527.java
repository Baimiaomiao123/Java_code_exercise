package com.baimiaomiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className GateWayMain9527
 * @since 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class GateWayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class, args);
    }

}