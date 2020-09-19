package com.qin_kai.configuration.config;

import com.qin_kai.configuration.properties.AppUserProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppUserConfig {


    /*
     * 使用 @Bean 配置 Bean时也可以通过@ConfigurationProperties进行配置
     * Bean 在创建时会自动将配置注入到 Bean 的属性中
     */
    @Bean("appUser2")
    @ConfigurationProperties(prefix = "app.user")
    public AppUserProperties appUser() {
        return new AppUserProperties();
    }

}
