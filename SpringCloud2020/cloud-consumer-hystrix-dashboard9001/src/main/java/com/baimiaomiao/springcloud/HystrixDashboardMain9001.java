package com.baimiaomiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className HystrixDashboardMain9001
 * @since 1.0
 */

@SpringBootApplication
@EnableHystrixDashboard //由于使用Dashboard，需要使用javax/servlet/Servlet，由于javax已经升级为jakarta，所以这里不再掩饰
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }

}
