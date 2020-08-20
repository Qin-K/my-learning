package com.qin_kai.kafkatest.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinkai
 * @date 2020-07-20 17:37:02
 **/
@RestController
@RequestMapping("/kafka")
public class KafkaNewsProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @PostMapping("/send")
    public String send(String msg) {
        kafkaTemplate.send("hello_topic", msg);
        return "send success";
    }

}
