package com.qin_kai.springtest.advancedassemblies.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public MyDataSource myDevDataSource() {
        return new MyDataSource("dev");
    }

    @Bean
    @Profile("prod")
    public MyDataSource myProdDataSource() {
        return new MyDataSource("prod");
    }

}
