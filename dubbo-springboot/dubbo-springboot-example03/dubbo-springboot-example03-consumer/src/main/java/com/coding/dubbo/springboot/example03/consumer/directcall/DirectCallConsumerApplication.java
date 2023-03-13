package com.coding.dubbo.springboot.example03.consumer.directcall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DirectCallConsumerApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "directcall");
        SpringApplication.run(DirectCallConsumerApplication.class, args);
    }
}
