package com.qin_kai.kafkatest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author qin kai
 * @date 2020/8/20
 */
public class KafkaConfig {
    private static Properties producerConfig = new Properties();
    private static Properties consumerConfig = new Properties();
    public static final String TOPIC = "test";
    public static final String GROUP_ID = "test";
    static {
        InputStream in = KafkaConfig.class.getResourceAsStream("/kafka-config.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            // producerConfig
            producerConfig.setProperty("bootstrap.servers", p.getProperty("bootstrap.servers"));
            producerConfig.setProperty("retries", p.getProperty("retries"));
            producerConfig.setProperty("acks", p.getProperty("acks"));
            producerConfig.setProperty("batch.size", p.getProperty("batch.size"));
            producerConfig.setProperty("linger.ms", p.getProperty("linger.ms"));
            producerConfig.setProperty("buffer.memory", p.getProperty("buffer.memory"));
            producerConfig.setProperty("key.serializer", p.getProperty("key.serializer"));
            producerConfig.setProperty("value.serializer", p.getProperty("value.serializer"));

            // consumerConfig
            consumerConfig.setProperty("bootstrap.servers", p.getProperty("bootstrap.servers"));
            consumerConfig.setProperty("group.id", p.getProperty("group.id"));
            consumerConfig.setProperty("enable.auto.commit", p.getProperty("enable.auto.commit"));
            consumerConfig.setProperty("auto.commit.interval.ms", p.getProperty("auto.commit.interval.ms"));
            consumerConfig.setProperty("key.deserializer", p.getProperty("key.deserializer"));
            consumerConfig.setProperty("value.deserializer", p.getProperty("value.deserializer"));
            System.out.println("=======加载配置文件成功======");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProducerConfig() {
        return producerConfig;
    }

    public static Properties getConsumerConfig() {
        return consumerConfig;
    }
}
