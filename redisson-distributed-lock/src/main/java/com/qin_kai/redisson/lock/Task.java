package com.qin_kai.redisson.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2022/7/21
 */
@Component
@Slf4j
public class Task {

    @Scheduled(cron = "* * * * * ?")
    @RedisLock(skip = true)
    void test() throws InterruptedException {
        log.info("test:" + Thread.currentThread().getName());
    }

}
