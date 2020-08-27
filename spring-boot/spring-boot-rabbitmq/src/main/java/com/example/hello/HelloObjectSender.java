package com.example.hello;

import com.example.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Qin Kai
 * @date 2019-08-26
 */
@Component
public class HelloObjectSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送对象
     */
    public void sendObject(User user) {
        System.out.println("send user: name is " + user.getName());
        amqpTemplate.convertAndSend("objectQueue", user);
    }

}
