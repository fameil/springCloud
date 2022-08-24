package com.srz.springcloud.alibaba.service;

/**
 * @author srz
 * @create 2022/8/20 0:14
 */
public interface StorageService {

    //扣减库存
    void decrease (Long productId,Integer count);
}
