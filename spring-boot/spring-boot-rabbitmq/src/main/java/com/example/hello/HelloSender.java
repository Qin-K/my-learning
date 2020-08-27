package com.example.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送者
 * @author Qin Kai
 * @date 2019-08-26
 */
@Component
public class HelloSender {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        System.out.println("send msg:" + msg);
        rabbitTemplate.convertAndSend("hello", msg);
    }
}
