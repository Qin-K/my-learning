package com.qin_kai.configuration;

import com.qin_kai.configuration.properties.AppUserProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ConfigurationApplication implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationApplication.class);

    @Resource
    private AppUserProperties appUser1;

    @Resource
    private AppUserProperties appUser2;


    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("user1={}", appUser1.toString());
        LOGGER.info("user2={}", appUser2.toString());
    }
}
