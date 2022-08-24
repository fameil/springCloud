package com.srz.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author srz
 * @create 2022/8/12 7:04
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String echo(@PathVariable("id") Integer id) {
        return "Hello Nacos Discovery,serverPort:"+serverPort+"\t  id:"+ id;
    }
}
