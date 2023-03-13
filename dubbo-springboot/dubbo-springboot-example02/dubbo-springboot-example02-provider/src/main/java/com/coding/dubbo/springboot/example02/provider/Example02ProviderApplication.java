package com.coding.dubbo.springboot.example02.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Example02ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example02ProviderApplication.class, args);
    }

}
