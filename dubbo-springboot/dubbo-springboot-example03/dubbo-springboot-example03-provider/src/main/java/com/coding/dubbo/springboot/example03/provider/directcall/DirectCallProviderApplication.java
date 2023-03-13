package com.coding.dubbo.springboot.example03.provider.directcall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DirectCallProviderApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "directcall");
        SpringApplication.run(DirectCallProviderApplication.class, args);
    }
}
