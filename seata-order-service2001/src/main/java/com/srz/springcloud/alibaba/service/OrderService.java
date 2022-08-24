package com.srz.springcloud.alibaba.service;

import com.srz.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author srz
 * @create 2022/8/18 15:12
 */
public interface OrderService {
    void create(Order order);
    Order show();
}
