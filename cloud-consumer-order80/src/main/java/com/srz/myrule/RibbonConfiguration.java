package com.srz.myrule;



import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author srz
 * @create 2022/7/20 22:17
 */
@Configuration
public class RibbonConfiguration {
/*    @Bean
    public IRule ribbonRule() {
        // 负载均衡规则，改为随机
        return new RandomRule();
    }*/
}
