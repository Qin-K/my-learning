package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Qin Kai
 * @date 2019-08-26
 */
@Configuration
public class RabbitConfig {

//    @Bean
//    public Queue queue() {
//        return new Queue("hello");
//    }

    @Bean
    public Queue objectQueue() {
        return new Queue("objectQueue");
    }

}
