package com.srz.zk;


import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author srz
 * @create 2022/7/15 14:59
 */
public class ZkClient {

    private String connectString="114.115.246.166:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zooKeeper;
    @Before
    public void init() throws IOException {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String nodeCreated = zooKeeper.create("/hello2", "liubei".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    }

}


