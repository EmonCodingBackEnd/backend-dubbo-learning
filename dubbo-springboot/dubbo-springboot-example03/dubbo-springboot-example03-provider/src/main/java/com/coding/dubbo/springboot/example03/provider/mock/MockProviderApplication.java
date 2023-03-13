package com.coding.dubbo.springboot.example03.provider.mock;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MockProviderApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "mock");
        SpringApplication.run(MockProviderApplication.class, args);
    }
}
