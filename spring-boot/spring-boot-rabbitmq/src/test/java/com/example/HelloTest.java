package com.example;

import com.example.hello.HelloObjectSender;
import com.example.hello.HelloSender;
import com.example.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Qin Kai
 * @date 2019-08-26
 */
public class HelloTest extends BaseTest {

    @Autowired
    private HelloObjectSender objectSender;

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() {
        helloSender.send("hello rabbit");
    }

    @Test
    public void sendObject(){
        User user = new User();
        user.setName("hello");
        user.setAge(10);
        objectSender.sendObject(user);
    }
}
