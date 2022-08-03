package com.srz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author srz
 * @create 2022/7/31 0:43
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class,args);
        System.out.println("hello git");
        System.out.println("hello git2");
        System.out.println("hello git2 hot-fix");
        System.out.println("hello git2 hot-fix test");
    }
}
