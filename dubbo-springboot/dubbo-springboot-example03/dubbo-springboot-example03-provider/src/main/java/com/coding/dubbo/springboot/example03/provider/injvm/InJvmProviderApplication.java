package com.coding.dubbo.springboot.example03.provider.injvm;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class InJvmProviderApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "injvm");
        SpringApplication.run(InJvmProviderApplication.class, args);
    }
}
