package com.coding.dubbo.springboot.example03.provider.retry;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class RetryProviderApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "retry");
        SpringApplication.run(RetryProviderApplication.class, args);
    }
}
