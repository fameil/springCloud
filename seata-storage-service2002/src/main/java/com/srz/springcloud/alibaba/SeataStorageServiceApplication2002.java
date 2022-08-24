package com.srz.springcloud.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author srz
 * @create 2022/8/19 22:58
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@ComponentScans({@ComponentScan("com.srz.springcloud.alibaba.dao")})
public class SeataStorageServiceApplication2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceApplication2002.class,args);
    }
}
