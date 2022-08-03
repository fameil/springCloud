package com.srz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author srz
 * @create 2022/7/17 21:20
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value ="/payment/consul")
    public String paymetnConsul(){
        return "springcloud with consul:" + serverPort+"\t" + UUID.randomUUID().toString();
    }



}
