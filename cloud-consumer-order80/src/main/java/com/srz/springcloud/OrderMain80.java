package com.srz.springcloud;


import com.srz.myrule.RibbonConfiguration;
import com.srz.springcloud.config.DefaultBalanceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author srz
 * @create 2022/7/7 22:38
 */


@SpringBootApplication
//EnableEurekaClient表明为EurekaClient
@EnableEurekaClient
//value值为被负载均衡的微服务名 configuration值为balance策略类
@LoadBalancerClient(value = "cloud-payment-service",configuration = DefaultBalanceRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }

}


