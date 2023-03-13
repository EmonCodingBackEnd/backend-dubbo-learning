package com.coding.dubbo.springboot.example01.consumer.app02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:example01-consumer02.xml")
public class Example01ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example01ConsumerApplication.class, args);
    }

}
