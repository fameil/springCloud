package com.srz.springcloud.alibaba;

import org.apache.ibatis.annotations.Mapper;
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
 * @create 2022/8/20 1:09
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@ComponentScans({@ComponentScan("com.srz.springcloud.alibaba.dao")})
public class SeataAccountMainApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp2003.class,args);
    }
}
