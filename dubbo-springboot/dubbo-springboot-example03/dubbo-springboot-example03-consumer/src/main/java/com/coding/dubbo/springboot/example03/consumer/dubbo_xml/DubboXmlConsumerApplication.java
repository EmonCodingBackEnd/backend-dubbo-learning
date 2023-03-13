package com.coding.dubbo.springboot.example03.consumer.dubbo_xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo-xml-consumer.xml")
public class DubboXmlConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboXmlConsumerApplication.class, args);
    }
}
