package com.qin_kai.kafkatest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author qin kai
 * @Date 2020/8/20
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Properties consumerConfig = KafkaConfig.getConsumerConfig();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(consumerConfig);
        consumer.subscribe(Collections.singletonList(KafkaConfig.TOPIC));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("收到 topic=%s, patition=%d, offset=%d的消息：\n%s\n",
                        record.topic(), record.partition(), record.offset(), record.value());
            }
        }
    }
}
