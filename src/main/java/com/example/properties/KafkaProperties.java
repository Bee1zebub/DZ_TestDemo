package com.example.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {
    private String broker = "";
    private String user = "";
    private String password = "remark2021";
    private String authMethod = "";
    private String securityProtocol = "SASL_SSL";
    private String topic = "iot-event";
}
