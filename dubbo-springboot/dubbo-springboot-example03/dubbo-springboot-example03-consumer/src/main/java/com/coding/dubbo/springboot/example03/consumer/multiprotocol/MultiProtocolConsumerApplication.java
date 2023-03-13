package com.coding.dubbo.springboot.example03.consumer.multiprotocol;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MultiProtocolConsumerApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "multiprotocol");
        SpringApplication.run(MultiProtocolConsumerApplication.class, args);
    }
}
