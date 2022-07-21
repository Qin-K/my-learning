package com.qin_kai.redisson.lock;

import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedissonLockTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void testLock() throws InterruptedException {
        RLock test = redissonClient.getLock("test");
//        test.lock(10, TimeUnit.SECONDS);
        // watch dog
        test.lock();
        System.out.println("lock success");
        try {
            Thread.sleep(10000);
        } finally {
            test.unlock();
        }
        System.out.println("unlock success");
    }

    @Test
    void testTryLock() throws InterruptedException {
        RLock test = redissonClient.getLock("test");

        // watch dog
//        boolean res = test.tryLock(10, TimeUnit.SECONDS);

        // no watch dog
        boolean res = test.tryLock(5, 10, TimeUnit.SECONDS);
        if (!res) {
            System.out.println("lock failed");
            return;
        }
        System.out.println("lock success");
        try {
            Thread.sleep(10000);
        } finally {
            test.unlock();
        }
        System.out.println("unlock success");
    }

    @Autowired
    private Task task;

    @Test
    void testLockAnnotation() throws InterruptedException {
        task.test();
    }

}