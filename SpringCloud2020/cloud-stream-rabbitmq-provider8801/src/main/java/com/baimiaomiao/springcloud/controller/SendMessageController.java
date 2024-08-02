package com.baimiaomiao.springcloud.controller;

import com.baimiaomiao.springcloud.service.IMessageProvider;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className SendMessageController
 * @since 1.0
 */

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
