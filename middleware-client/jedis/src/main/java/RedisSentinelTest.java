package com.qin_kai;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Qin Kai
 * @date 2019-12-04
 */
@Slf4j
public class RedisSentinelTest {
    private static final String masterName = "mymaster";
    private static Set<String> sentinels = new HashSet<>();

    public static void main(String[] args) {
        sentinels.add("47.106.190.87:26379");
        sentinels.add("47.106.190.87:26380");
        sentinels.add("47.106.190.87:26381");
        JedisSentinelPool sentinelPool = new JedisSentinelPool(masterName, sentinels);
        Jedis jedis = null;
        while (true) {
            try {
                jedis = sentinelPool.getResource();

                int index = new Random().nextInt(1000);
                String key = "k-" + index;
                String value = "v-" + index;
                jedis.set(key, value);
                log.info("key = {}, value = {}", key, value);
                Thread.sleep(10);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
    }
}
