package com.srz.springcloud.alibaba.controller;

import com.srz.springcloud.alibaba.domain.CommonResult;
import com.srz.springcloud.alibaba.domain.Order;
import com.srz.springcloud.alibaba.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author srz
 * @create 2022/8/19 13:53
 */

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    @GlobalTransactional
    public CommonResult create(Order order){
        System.out.println("进入order");
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

    @GetMapping("/show")
    public String show(){
        System.out.println("show");
        Order order = orderService.show();
        return order.toString();
    }
    @GetMapping("/hello")
    public String hello(){

        return "seata_hello";
    }


}
