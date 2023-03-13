package com.coding.dubbo.springboot.example01.provider.app02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:example01-provider02.xml")
public class Example01ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example01ProviderApplication.class, args);
    }
}