package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public static final String TOPIC_NAME = "iot-event";

    @RequestMapping("/hello")
    public void test() {
        Producer producer = kafkaTemplate.getProducerFactory().createProducer();
        log.info("aa");
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_NAME, "test", "datfea111gwtger");
        producer.send(producerRecord, (metadata, exception) -> System.out.println("send---success"));
        log.info("bb");
    }
}

