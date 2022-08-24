package com.srz.springcloud.alibaba.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author srz
 * @create 2022/8/20 1:38
 */
@Service
public interface AccountService {
    //扣减账户余额
    void decrease(@RequestParam("userId")Long userId, @RequestParam("money")BigDecimal money);
}
