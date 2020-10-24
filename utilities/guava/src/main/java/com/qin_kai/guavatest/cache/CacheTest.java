package com.qin_kai.guavatest.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author qin kai
 * @date 2020/8/26
 */
public class CacheTest {
    public static void main(String[] args) {
        LoadingCache<Integer, User> userCache = CacheBuilder.newBuilder()
                .softValues() // 缓存的 value 为SoftReference 内存不足时回收
                .initialCapacity(1000) // 初始容量
                .maximumSize(1000) // 缓存最大个数
                .concurrencyLevel(Runtime.getRuntime().availableProcessors()) // 并发数
//                .expireAfterWrite(30, TimeUnit.SECONDS) // 缓存多久过期
                .refreshAfterWrite(15, TimeUnit.SECONDS) // 写入15s后刷新缓存
                .build(new UserCacheLoader());

        try {
            System.out.println(userCache.get(1));
            System.out.println(userCache.get(10));
            System.out.println(userCache.get(100));
            System.out.println(userCache.get(1000));
        } catch (ExecutionException e) {
            System.out.println("缓存获取失败。。。");
        }
    }
}
