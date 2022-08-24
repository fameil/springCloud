package com.srz.springcloud.alibaba.service.impl;

import com.srz.springcloud.alibaba.dao.AccountDao;
import com.srz.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author srz
 * @create 2022/8/20 1:40
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("============account-service扣减余额开始");
        accountDao.decrease(userId, money);
        int i = 1/0;
        log.info("============account-service扣减余额结束");
    }
}
