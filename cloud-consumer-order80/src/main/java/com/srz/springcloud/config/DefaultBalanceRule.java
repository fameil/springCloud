package com.srz.springcloud.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author srz
 * @create 2022/7/21 22:41
 */
public class DefaultBalanceRule {
    @Bean
    public ReactorLoadBalancer<ServiceInstance> balancer(Environment environment, LoadBalancerClientFactory clientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RandomLoadBalancer(clientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),name);
    }
//        RandomLoadBalancer();//随机
//        RoundRobinLoadBalancer();//轮询

}
