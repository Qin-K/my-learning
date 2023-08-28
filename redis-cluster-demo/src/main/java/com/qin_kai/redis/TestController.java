package com.qin_kai.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinkai
 * @date 2023/8/22
 */
@RestController
public class TestController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
