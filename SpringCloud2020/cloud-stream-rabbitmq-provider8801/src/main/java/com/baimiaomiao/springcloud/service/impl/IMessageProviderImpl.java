package com.baimiaomiao.springcloud.service.impl;

import com.baimiaomiao.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className IMessageProviderImpl
 * @since 1.0
 */

@Component
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    //这里直接装配一个桥，用于连接rabbit或kafka
    private final StreamBridge streamBridge;

    public IMessageProviderImpl(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        //这里说明一下这个 streamBridge.send 方法的参数 第一个参数是exchange或者topic 就是主题名称
        //默认的主题名称是通过
        //输入:    <方法名> + -in- + <index>
        //输出:    <方法名> + -out- + <index>
        //这里我们接收的时候就要用send方法 参数是consumer<String>接收  详情看8802的controller
        //consumer的参数类型是这里message的类型
        streamBridge.send("send-in-0",message);
        log.info("******发送message:" + message);
        return message;
    }
}
