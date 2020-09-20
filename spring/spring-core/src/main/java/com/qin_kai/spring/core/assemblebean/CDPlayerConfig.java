package com.qin_kai.spring.core.assemblebean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qin kai
 * @Date 2020/8/24
 */
// Configuration 指定这是一个配置类，可以通过JavaConfig bean的方式装配
@Configuration
public class CDPlayerConfig {


    // 使用 @Bean 注解，方法返回的结果会交给Spring管理，bean名字为方法名
    @Bean
    public CDPlayer cdPlayer(CompactDisc disc) {
        return new CDPlayer(disc);
    }

    @Bean
    public CompactDisc compactDisc() {
        return new CompactDisc();
    }
}
