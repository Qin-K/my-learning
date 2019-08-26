package com.example.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受者
 * @author Qin Kai
 * @date 2019-08-26
 */
@Component
@RabbitListener(queues = {"hello"})
public class HelloReciver {

    @RabbitHandler
    public void reciver(String msg) {
        System.out.println("recived msg:" + msg);
    }

}
