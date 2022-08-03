package com.srs.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author srz
 * @create 2022/7/29 0:17
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "------ paymentInfo_OK fall back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------ paymentInfo_TimeOut fall back";
    }
}
