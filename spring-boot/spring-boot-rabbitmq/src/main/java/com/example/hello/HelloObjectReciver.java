package com.example.hello;

import com.example.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Qin Kai
 * @date 2019-08-26
 */
@Component
@RabbitListener(queues = {"objectQueue"})
public class HelloObjectReciver {

    @RabbitHandler
    public void recive(User user) {
        System.out.println("recived msg: " + user);
    }

}
