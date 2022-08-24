package com.srz.springcloud.controller;

import com.srz.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author srz
 * @create 2022/8/10 5:01
 */
@RestController
public class SendMessageController {

    private final IMessageProvider messageProvider;

    public SendMessageController(IMessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}