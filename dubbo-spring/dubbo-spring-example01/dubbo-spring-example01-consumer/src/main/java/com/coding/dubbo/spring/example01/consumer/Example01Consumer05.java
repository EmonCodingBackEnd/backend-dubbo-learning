package com.coding.dubbo.spring.example01.consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import com.coding.dubbo.spring.example01.api.HelloService;

public class Example01Consumer05 {

    public static void main(String[] args) throws IOException {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-spring-example01-consumer");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("qos.enable", "true");
        parameters.put("qos.accept.foreign.ip", "false");
        parameters.put("qos.port", "33333");
        application.setParameters(parameters);

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://emon:2181");

        // 引用远程服务
        ReferenceConfig<HelloService> helloServiceReference = new ReferenceConfig<>();
        helloServiceReference.setInterface(HelloService.class);
        helloServiceReference.setVersion("V1.0.0");

        // 通过DubboBootstrap简化配置组装，控制启动过程
        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(application) // 应用配置
            .registry(registry) // 注册中心配置
            .reference(helloServiceReference) // 添加ReferenceConfig
            .start(); // 启动Dubbo

        // 和本地bean一样使用demoService
        // 通过Interface获取远程服务接口代理，不需要依赖ReferenceConfig对象
        HelloService helloService = DubboBootstrap.getInstance().getCache().get(HelloService.class);
        String hello = helloService.sayHello("world");
        System.out.printf("=========>%s%n", hello); // 显示调用结果
    }
}
