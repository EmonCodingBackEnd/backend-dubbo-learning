package com.coding.dubbo.springboot.example03.provider.dubbo_java_config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@Configuration
public class DubboJavaConfiguration {

    @Bean
    public ApplicationConfig application() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-java-config-provider");
        application.setRegisterMode("instance");
        return application;
    }

    @Bean
    public RegistryConfig registry() {
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://emon:2181");
        return registry;
    }

    @Bean
    public ProtocolConfig protocol() {
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setId("tri"); // 默认同name
        protocol.setName("tri");
        protocol.setPort(-1);
        return protocol;
    }

    @Bean
    public ServiceConfig<InterfaceService> service() {
        ServiceConfig<InterfaceService> service = new ServiceConfig<>();

        service.setId("providerInterfaceService");
        service.setInterface(InterfaceService.class);
        service.setRef(new DubboJavaConfigServiceImpl());
        service.setVersion("V1.0.0");
        service.export();

        return service;
    }
}
