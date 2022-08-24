package com.srz.springcloud.alibaba.controller;

import com.srz.springcloud.alibaba.domain.CommonResult;
import com.srz.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author srz
 * @create 2022/8/20 0:22
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功!");

    }
}
