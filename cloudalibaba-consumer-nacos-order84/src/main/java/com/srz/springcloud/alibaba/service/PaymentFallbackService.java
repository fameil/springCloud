package com.srz.springcloud.alibaba.service;

import com.srz.springcloud.entities.CommonResult;
import com.srz.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author srz
 * @create 2022/8/17 9:15
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"PaymentFallbackService-----服务降级返回...",new Payment(id,"errorSerial"));
    }
}
