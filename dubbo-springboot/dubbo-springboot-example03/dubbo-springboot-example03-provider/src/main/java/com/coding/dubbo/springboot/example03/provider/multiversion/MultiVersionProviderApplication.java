package com.coding.dubbo.springboot.example03.provider.multiversion;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MultiVersionProviderApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "multiversion");
        SpringApplication.run(MultiVersionProviderApplication.class, args);
    }
}
