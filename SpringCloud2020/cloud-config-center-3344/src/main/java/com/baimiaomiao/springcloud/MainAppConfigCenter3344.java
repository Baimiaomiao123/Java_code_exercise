package com.baimiaomiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className MainAppConfigCenter3344
 * @since 1.0
 */

@SpringBootApplication
@EnableConfigServer
public class MainAppConfigCenter3344 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigCenter3344.class, args);
    }

}
