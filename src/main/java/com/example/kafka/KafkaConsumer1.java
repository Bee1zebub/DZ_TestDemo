package com.example.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class KafkaConsumer1 {

    //@KafkaListener(topics = "topic-test", groupId = "consumer-group-test")
    @KafkaListener(topics = "iot-event")
    public void topicTest(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("客户端 A 消费了： Topic{} Message{}", topic, msg);
//            ack.acknowledge();
        }
    }

//    @KafkaListener(topics = "topic.test", groupId = "topic.group1")
//    public void topicTest1(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        Optional message = Optional.ofNullable(record.value());
//        if (message.isPresent()) {
//            Object msg = message.get();
//            log.info("客户端 B 消费了： Topic[{}] Message[{}]", topic, msg);
//            ack.acknowledge();
//        }
//
//    }
}
