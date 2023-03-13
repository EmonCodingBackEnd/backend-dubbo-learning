package com.coding.dubbo.springboot.example01.provider.app01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:example01-provider01.xml")
public class Example01ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example01ProviderApplication.class, args);
    }
}