package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Kafka03_Test_Consumer_Offset_2 {
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

        // 创建配置对象，增加常规配置
        Properties props1 = new Properties();
        // 配置集群地址
        props1.put("bootstrap.servers", "linux1:9092");
        // ACK应答
        props1.put("acks", "all");
        // 重试次数
        props1.put("retries", 1);
        // 批次大小 16K
        props1.put("batch.size", 16384);
        props1.put("linger.ms", 1);//等待时间
        // 缓冲区内存大小 32M
        props1.put("buffer.memory", 33554432);//RecordAccumulator缓冲区大小
        // Kafka发送数据时以k-v键值对方式发送
        props1.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props1.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        props1.put("interceptor.classes", "com.atguigu.itdachang.kafka.MyProducerInterceptor");
        props1.put("enable.idempotence", "true");
        props1.put("transactional.id", "test");
        // 构建生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(props1);

        // 提交自定义的偏移量
        // 将获取的数据进行业务操作，如果业务操作成功，那么提交对应的偏移量。
        producer.initTransactions();
        while (true) {
            producer.beginTransaction();
            try {

                ConsumerRecords<String, String> records = consumer.poll(1000);
                //System.out.println("cnt = " + records.count());
                Map<TopicPartition, OffsetAndMetadata> map = new HashMap<>();
                for (ConsumerRecord<String, String> record : records) {
                    map.put(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset()));
                }
                // 将生产者和消费者融合在一起
                producer.send(new ProducerRecord<String, String>("itdachang-2", "test"));
                producer.sendOffsetsToTransaction(map, "itdachang");
                producer.commitTransaction();
            } catch ( Exception e ) {
                producer.abortTransaction();
            } finally {
            }
        }


    }
}

