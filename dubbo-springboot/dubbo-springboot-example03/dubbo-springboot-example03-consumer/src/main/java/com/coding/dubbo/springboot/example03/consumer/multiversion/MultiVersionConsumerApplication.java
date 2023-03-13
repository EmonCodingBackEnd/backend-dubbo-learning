package com.coding.dubbo.springboot.example03.consumer.multiversion;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MultiVersionConsumerApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "multiversion");
        SpringApplication.run(MultiVersionConsumerApplication.class, args);
    }
}
