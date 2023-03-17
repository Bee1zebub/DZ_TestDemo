package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Kafka03_Test_Consumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "linux1:9092");
        // Kafka中消费数据以消费者组为单位消费
        props.put("group.id", "itdachang");
        // Kafka的数据日志文件中有偏移量的概念，用于消费数据，可以消费指定偏移量的数据，而且可以重复消费
        // 消费者消费数据时也需要记录偏移量。涉及到提交的概念。提交的就是消费的偏移量
        // 提交后，消费者继续消费，就会从指定的位置往后消费，之前的数据就消费不到
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("itdachang-1"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            System.out.println("cnt = " + records.count());
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }
}

