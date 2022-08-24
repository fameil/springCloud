package com.srz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author srz
 * @create 2022/8/5 10:00
 * //CMD运行命令可刷新配置：curl -X POST "http://localhost:3344/actuator/bus-refresh" 报错405
 */
//是因为版本更新的缘故，新版本应该使用/actuator/busrefresh
//CMD运行命令可刷新配置：curl -X POST "http://localhost:3344/actuator/busrefresh"
//CMD运行命令单点通知：curl -X POST "http://localhost:3344/actuator/busrefresh/config-client:3355"
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
