package com.coding.dubbo.springboot.example03.provider.dubbo_java_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 【注意：注册失败】
@SpringBootApplication
public class DubboJavaConfigProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboJavaConfigProviderApplication.class, args);
    }
}
