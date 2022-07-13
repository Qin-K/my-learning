package com.qin_kai.redisson.lock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author qinkai
 * @date 2022/7/13
 */
public class RedissonClientHolder {

    private static volatile RedissonClient redissonClient;

    public static RedissonClient getClient() {
        if (redissonClient == null) {
            synchronized (RedissonClientHolder.class) {
                if (redissonClient == null) {
                    redissonClient = createClient();
                }
            }
        }
        return redissonClient;
    }

    private static RedissonClient createClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://10.228.131.2:6379")
                .setPassword("^^DyYoz6!NEW8hXwTyUxQwVdaL");
        return Redisson.create(config);
    }
}
