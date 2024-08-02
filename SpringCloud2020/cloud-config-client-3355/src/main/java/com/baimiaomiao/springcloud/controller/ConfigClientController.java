package com.baimiaomiao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className ConfigClientController
 * @since 1.0
 */

@RestController
@RefreshScope //具备刷新能力，但是一定要用POST请求方式才能进行刷新（curl -X POST "http://localhost:3355/actuator/refresh"）
public class ConfigClientController {

    @Value("${config.info}") //这里一定要对应github仓库中config-dev.yml文件格式一致
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
