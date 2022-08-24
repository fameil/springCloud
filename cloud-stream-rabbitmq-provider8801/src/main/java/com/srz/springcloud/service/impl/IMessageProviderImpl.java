package com.srz.springcloud.service.impl;

import com.srz.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author srz
 * @create 2022/8/10 4:20
 */
@Service
public class IMessageProviderImpl implements IMessageProvider {
    private final StreamBridge streamBridge;

    public IMessageProviderImpl(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        streamBridge.send("myChannel-out-0", MessageBuilder.withPayload(uuid).build());
        System.out.println("发送消息: " + uuid);
        return null;
    }
}
