package com.qin_kai.spring.core.advancedassemblies.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author qin kai
 * @Date 2020/8/25
 */

// @Profile指定环境 这里只有环境为prod时配置才生效
@Profile("prod")
@Configuration
public class ProdctionProfileConfig {

    @Bean
    public MyDataSource dataSource() {
        return  new MyDataSource("prod");
    }
}
