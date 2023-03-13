package com.coding.dubbo.springboot.example03.consumer.timeout;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class TimeoutConsumerApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "timeout");
        SpringApplication.run(TimeoutConsumerApplication.class, args);
    }
}
