package com.srz.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author srz
 * @create 2022/8/15 16:06
 */
@RestController
public class FlowLimitController {
    int count = 0 ;

    @GetMapping("/testA")
    public String testA(){

        count += 1;
        return "========testA:"+count;
    }

    @GetMapping("/testB")
    public String testB(){
        count += 1;
        System.out.println(count + ":"+ Thread.currentThread().getName());
        return "========testB:"+count;
    }
    @GetMapping("/testD")
    public String testD() throws InterruptedException {
      //  TimeUnit.MILLISECONDS.sleep(1000);
        int a = 1/0;
        count += 1;
        System.out.println(count + ":"+ Thread.currentThread().getName());
        return "========testD:"+count;
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String s1,
                             @RequestParam(value = "p2",required = false)String s2) throws InterruptedException {
        count += 1;
        System.out.println(count);
        int a = 1/0;
        return "========testHotKey:"+count;
    }

    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "==========deal_testHotKey,0..0!";
    }


}
