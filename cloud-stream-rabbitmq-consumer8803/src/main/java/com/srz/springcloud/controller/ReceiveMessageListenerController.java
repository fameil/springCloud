package com.srz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author srz
 * @create 2022/8/10 5:58
 */
@Component
@Slf4j
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @Bean
    public Consumer<String> myChannel() {
        return message -> log.info("消息："+message+"\t port:"+serverPort);
    }
}
