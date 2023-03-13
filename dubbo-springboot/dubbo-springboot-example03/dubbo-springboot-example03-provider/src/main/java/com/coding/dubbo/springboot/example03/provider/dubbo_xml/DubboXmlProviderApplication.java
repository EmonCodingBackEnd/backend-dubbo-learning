package com.coding.dubbo.springboot.example03.provider.dubbo_xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo-xml-provider.xml")
public class DubboXmlProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboXmlProviderApplication.class, args);
    }
}
