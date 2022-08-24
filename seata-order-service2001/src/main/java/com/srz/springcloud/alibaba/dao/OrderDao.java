package com.srz.springcloud.alibaba.dao;

import com.srz.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import javax.annotation.Resource;

/**
 * @author srz
 * @create 2022/8/17 23:37
 */
@Mapper
public interface OrderDao {

    //1. 新建订单
    void create(Order order);

    //2. 修改订单状态，从0改为1
    void update(@Param("userId") Long userId,@Param("status") Integer status);

    Order show();


}
