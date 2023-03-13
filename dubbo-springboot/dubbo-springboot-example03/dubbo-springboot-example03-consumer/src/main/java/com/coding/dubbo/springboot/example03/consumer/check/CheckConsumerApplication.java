package com.coding.dubbo.springboot.example03.consumer.check;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class CheckConsumerApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "check");
        SpringApplication.run(CheckConsumerApplication.class, args);
    }
}
