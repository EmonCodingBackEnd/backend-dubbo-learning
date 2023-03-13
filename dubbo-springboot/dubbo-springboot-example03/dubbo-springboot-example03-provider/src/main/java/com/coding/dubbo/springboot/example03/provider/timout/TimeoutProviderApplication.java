package com.coding.dubbo.springboot.example03.provider.timout;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class TimeoutProviderApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "timeout");
        SpringApplication.run(TimeoutProviderApplication.class, args);
    }
}
