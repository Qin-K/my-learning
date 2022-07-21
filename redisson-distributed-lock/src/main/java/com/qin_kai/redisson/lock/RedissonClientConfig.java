package com.qin_kai.redisson.lock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinkai
 * @date 2022/7/13
 */
@Configuration
public class RedissonClientConfig {

    @Bean
    @ConditionalOnMissingBean(RedissonClient.class)
    public RedissonClient redissonClient(RedisProperties redisProperties) {
        Config config = new Config();
        if (redisProperties.getCluster() != null) {
            List<String> nodes = nodeConvert(redisProperties.getCluster().getNodes());
            config.useClusterServers()
                    .setPassword(redisProperties.getPassword())
                    .setNodeAddresses(nodes);
        } else if (redisProperties.getSentinel() != null) {
            List<String> nodes = nodeConvert(redisProperties.getSentinel().getNodes());
            config.useSentinelServers()
                    .setPassword(redisProperties.getPassword())
                    .setSentinelAddresses(nodes);
        } else {
            config.useSingleServer()
                    .setPassword(redisProperties.getPassword())
                    .setAddress("redis://" + redisProperties.getHost() + ":" + redisProperties.getPort());
        }
        return Redisson.create(config);
    }

    private List<String> nodeConvert(List<String> nodes) {
        List<String> redisNodes = new ArrayList<>();
        for (String node : nodes) {
            redisNodes.add("redis://" + node);
        }
        return redisNodes;
    }
}
