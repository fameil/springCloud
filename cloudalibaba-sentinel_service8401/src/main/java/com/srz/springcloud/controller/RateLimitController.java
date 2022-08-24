package com.srz.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.srz.springcloud.entities.CommonResult;
import com.srz.springcloud.entities.Payment;
import com.srz.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author srz
 * @create 2022/8/16 13:23
 */
@RestController
public class RateLimitController {
    int count = 0;

    @GetMapping("/byResuorce")
    @SentinelResource(value = "byResuorce",blockHandler = "handleException")
    public CommonResult byResuorce(){
        count += 1;
        return new CommonResult(200,"按资源名称限流测试OK,count:"+count,new Payment(2022L,"serial001"));
    }
    public CommonResult handleException(BlockException exception){
        count += 1;
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用,count:"+count);
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        count += 1;
        return new CommonResult(200,"按url限流测试OK,count:"+count,new Payment(2022L,"serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        count += 1;
        return new CommonResult(200,"customerBlockHandler测试OK,count:"+count,new Payment(2022L,"serial003"));
    }



}
