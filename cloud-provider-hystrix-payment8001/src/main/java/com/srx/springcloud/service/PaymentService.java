package com.srx.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author srz
 * @create 2022/7/26 0:13
 */
@Service
public class PaymentService {

    /**
     * 正常访问,肯定成功!
     * @param id
     * @return
     */


    public String paymentInfo_OK(Integer id){
        return "线程池:" +Thread.currentThread()+" paymentInfo_OK:"+id;
    }




    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int time = 3;
        //int age = 1/0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" +Thread.currentThread()+" paymentInfo_TimeOut:"+id+"耗时(秒):"+ time;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池:" +Thread.currentThread()+" paymentInfo_TimeOutHandler:"+"系统繁忙请稍后再试！";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0 ){
            throw new RuntimeException("----ID 不能为负数----");
        }
        String uuid = IdUtil.simpleUUID();
        String threadName = Thread.currentThread().getName();
        return threadName+"\t"+":调用成功，流水号："+uuid;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试~" + id;
    }

}
