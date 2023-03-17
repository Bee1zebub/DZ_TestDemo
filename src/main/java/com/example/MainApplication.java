package com.example;

import com.example.properties.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(MainApplication.class, args);
        KafkaProperties properties = application.getBean(KafkaProperties.class);
        System.out.println(properties);
    }
}
