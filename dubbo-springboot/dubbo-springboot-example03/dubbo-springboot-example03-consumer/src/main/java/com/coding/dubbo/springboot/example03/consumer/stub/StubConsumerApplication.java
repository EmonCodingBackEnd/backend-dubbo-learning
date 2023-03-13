package com.coding.dubbo.springboot.example03.consumer.stub;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class StubConsumerApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "stub");
        SpringApplication.run(StubConsumerApplication.class, args);
    }
}
