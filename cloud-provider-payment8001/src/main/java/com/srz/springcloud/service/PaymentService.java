package com.srz.springcloud.service;

import com.srz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author srz
 * @create 2022/7/6 20:34
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
