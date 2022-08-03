package com.srz.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author srz
 * @create 2022/7/25 22:19
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLogerLevel(){
        return Logger.Level.FULL;
    }

}
