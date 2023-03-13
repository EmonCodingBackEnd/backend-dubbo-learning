package com.coding.dubbo.springboot.example03.provider.stub;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class StubProviderApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "stub");
        SpringApplication.run(StubProviderApplication.class, args);
    }
}
