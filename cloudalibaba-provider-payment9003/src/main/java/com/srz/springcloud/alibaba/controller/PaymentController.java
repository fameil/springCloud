package com.srz.springcloud.alibaba.controller;

import com.srz.springcloud.entities.CommonResult;
import com.srz.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author srz
 * @create 2022/8/16 20:43
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"z8dfds6678999f90gg0989080r3"));
        hashMap.put(2L,new Payment(2L,"fd8d8f9ddf999f90gg0989080we"));
        hashMap.put(3L,new Payment(3L,"ewrew990e678999f90gg098werr"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200,"FROM SQL,serverPort: " + serverPort,payment);
    }

}
