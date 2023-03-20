package com.example.testkafka;

import com.example.properties.KafkaProperties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaTest {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Test
    public void test01(){

        System.out.println(kafkaProperties);
    }
}
