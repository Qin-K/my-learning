package com.qin_kai.kafkatest;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * @author qin kai
 * @date 2020/8/20
 */
public class ProducerTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties producerConfig = KafkaConfig.getProducerConfig();
        KafkaProducer<String, String> producer = new KafkaProducer<>(producerConfig);
        Scanner sc = new Scanner(System.in);
        String msg;
        while ((msg = sc.nextLine()) != null) {
            RecordMetadata recordMetadata = producer.send(new ProducerRecord<>(KafkaConfig.TOPIC, msg)).get();
            System.out.printf("发送消息成功, topic=%s, partition=%s, offset=%s\n",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
        }
        System.out.println("消息发送结束!");
    }
}
