package com.srz.springcloud.alibaba.controller;

import com.srz.springcloud.alibaba.domain.CommonResult;
import com.srz.springcloud.alibaba.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author srz
 * @create 2022/8/20 1:44
 */
@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId")Long userId,@RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"扣减账户余额成功!");
    }
}
