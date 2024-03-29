package com.qin_kai.kafkatest.news;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2020-07-20 17:38:38
 **/
@Component
public class KafkaNewsConsumer {

    @KafkaListener(topics = {"hello_topic"})
    public void listen(ConsumerRecord<String, String> record) {
        System.out.printf("topic = %s, offset = %s, value = %s \n", record.topic(), record.offset(), record.value());
    }
}
