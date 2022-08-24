package com.srz.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.srz.springcloud.entities.CommonResult;
import com.srz.springcloud.entities.Payment;

/**
 * @author srz
 * @create 2022/8/16 14:17
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"customerBlockHandler测试,global handlerException-----1");

    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"customerBlockHandler测试,global handlerException-----2");

    }
}
