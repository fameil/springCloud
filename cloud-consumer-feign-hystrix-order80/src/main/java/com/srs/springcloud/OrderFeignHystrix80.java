package com.srs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author srz
 * @create 2022/7/26 23:20
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrix80.class,args);

    }
}
