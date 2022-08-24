package com.srz.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * @author srz
 * @create 2022/8/19 23:54
 */
@Mapper
public interface StorageDao {

    //扣减库存
    void decrease(@Param("productId")Long productId,@Param("count")Integer count);
}
