package com.srz.springcloud.alibaba.service.impl;

import com.srz.springcloud.alibaba.dao.OrderDao;
import com.srz.springcloud.alibaba.domain.Order;
import com.srz.springcloud.alibaba.service.AccountService;
import com.srz.springcloud.alibaba.service.OrderService;
import com.srz.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * @author srz
 * @create 2022/8/18 15:15
*/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("=========>开始新建订单<=========");
        orderDao.create(order);
        log.info("------>订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------>订单微服务开始调用账户，扣减余额Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------>修改订单状态");
        //4. 修改订单状态，从零到1，1代表已经完成
        orderDao.update(order.getUserId(),0);
        log.info("=========>下订单结束<=========");
    }

    @Override
    public Order show() {
        log.info("=========><=========");
        Order order = orderDao.show();
        log.info("=========><=========");
        return order;

    }
}
