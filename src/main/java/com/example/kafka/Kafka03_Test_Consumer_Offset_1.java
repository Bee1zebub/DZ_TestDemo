package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Kafka03_Test_Consumer_Offset_1 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "linux1:9092");
        // Kafka中消费数据以消费者组为单位消费
        props.put("group.id", "itdachang");
        // 禁用自动提交
        props.put("enable.auto.commit", "false");
        // 消费方式：从最新的位置读，还是从最早的位置读取数据
        props.put("auto.offset.reset", "earliest");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("itdachang-1"));

        // 提交自定义的偏移量
        // 将获取的数据进行业务操作，如果业务操作成功，那么提交对应的偏移量。

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                //System.out.println("cnt = " + records.count());
                Map<TopicPartition, OffsetAndMetadata> map = new HashMap<>();
                for (ConsumerRecord<String, String> record : records) {
                    map.put(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset()));
                }
                    //System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());

                // 当数据消费完成后，应该提交偏移量，告诉Kafka，消费者的消费进度
                // 异步提交 组合使用
                consumer.commitAsync(map, null);
            }
        } catch ( Exception e ) {

        } finally {
            try {
                // 同步提交
                consumer.commitSync();
            } catch ( Exception e ) {

            }
        }

    }
}

