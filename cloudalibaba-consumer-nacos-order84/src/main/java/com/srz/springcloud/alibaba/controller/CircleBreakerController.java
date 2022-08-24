package com.srz.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.srz.springcloud.alibaba.service.PaymentService;
import com.srz.springcloud.entities.CommonResult;
import com.srz.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author srz
 * @create 2022/8/12 10:51
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")
    //@SentinelResource(value = "fallback",blockHandler = "handlerException")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "handlerException",
                    exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallBack(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(serverURL+"/paymentSQL/"+id,CommonResult.class,id);
        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常!");
        } else if(result.getData()==null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常!");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"handlerFallback，exception内容 "+ e.getMessage(),payment);
    }

    public static CommonResult handlerException(@PathVariable Long id,BlockException blockException){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"handlerException，exception内容 "+ blockException.getMessage(),payment);
    }

    //============OpenFein
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/OpenFeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id){
        return paymentService.paymentSQL(id);
    }

}
