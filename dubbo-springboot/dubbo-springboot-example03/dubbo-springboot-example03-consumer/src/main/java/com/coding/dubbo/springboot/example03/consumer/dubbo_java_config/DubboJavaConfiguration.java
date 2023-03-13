package com.coding.dubbo.springboot.example03.consumer.dubbo_java_config;

import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@Configuration
public class DubboJavaConfiguration {

    @Bean
    public ApplicationConfig application() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-java-config-consumer");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("qos.enable", "true");
        parameters.put("qos.accept.foreign.ip", "false");
        parameters.put("qos.port", "33333");
        application.setParameters(parameters);
        return application;
    }

    @Bean
    public RegistryConfig registry() {
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://emon:2181");
        return registry;
    }

    @Bean
    public ReferenceConfig<InterfaceService> reference() {
        ReferenceConfig<InterfaceService> reference = new ReferenceConfig<>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application());
        reference.setRegistry(registry()); // 多个注册中心可以用setRegistries()

        reference.setId("consumerHelloService");
        reference.setInterface(InterfaceService.class);
        reference.setVersion("V1.0.0");
        return reference;
    }
}
