package com.srz.springcloud.alibaba.service.impl;

import com.srz.springcloud.alibaba.dao.StorageDao;
import com.srz.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author srz
 * @create 2022/8/20 0:16
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("========>storage-service扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("========>storage-service扣减库存完成");

    }
}
