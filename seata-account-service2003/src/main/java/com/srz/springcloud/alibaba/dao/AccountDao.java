package com.srz.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author srz
 * @create 2022/8/20 1:18
 */
@Mapper
public interface AccountDao {

    //扣减账户余额
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);

}
