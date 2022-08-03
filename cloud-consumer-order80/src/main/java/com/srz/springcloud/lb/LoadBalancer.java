package com.srz.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author srz
 * @create 2022/7/23 18:14
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
