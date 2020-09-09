package com.qin_kai.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author qin kai
 * @Date 2020/9/9
 */
@Configuration
public class KeyResolverConfig {

    @Bean
    public KeyResolver userKeyResolver() {
        // 根据请求的用户限流（user参数模拟用户）
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

//    @Bean
//    public KeyResolver ipKeyResolver() {
//        // 根据请求的ip地址限流
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
//    }

}
