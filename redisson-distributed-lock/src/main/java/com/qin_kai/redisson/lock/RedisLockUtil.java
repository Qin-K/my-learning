package com.qin_kai.redisson.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2022/7/21
 */
@Component
public class RedisLockUtil {

    private static RedissonClient redissonClient;

    public static RLock getLock(String key) {
        return redissonClient.getLock(key);
    }

    @Autowired
    public void setRedissonClient(RedissonClient redissonClient) {
        RedisLockUtil.redissonClient = redissonClient;
    }
}
