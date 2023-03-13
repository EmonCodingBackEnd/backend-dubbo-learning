package com.coding.dubbo.springboot.example02.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Example02ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example02ConsumerApplication.class, args);
    }

}
