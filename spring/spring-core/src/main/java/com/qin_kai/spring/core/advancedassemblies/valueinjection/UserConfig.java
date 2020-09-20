package com.qin_kai.spring.core.advancedassemblies.valueinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
@Configuration
@PropertySource("classpath:user.properties")
public class UserConfig {

//    @Autowired
//    private Environment env;
//
//    @Bean
//    public User user() {
//        User user = new User();
//        user.setName(env.getProperty("user.name"));
//        user.setAge(env.getProperty("user.age", Integer.class));
//        return user;
//    }

    @Bean
    User user2(@Value("${user.name}") String name, @Value("${user.age}") int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }


    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
