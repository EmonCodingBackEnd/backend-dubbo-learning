package com.coding.dubbo.spring.example01.consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import com.coding.dubbo.spring.example01.api.HelloService;

public class Example01Consumer04 {

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

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
        // 引用远程服务
        ReferenceConfig<HelloService> reference = new ReferenceConfig<>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(HelloService.class);
        reference.setVersion("V1.0.0");

        // 和本地bean一样使用helloService
        HelloService helloService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        String hello = helloService.sayHello("world"); // 执行远程方法
        System.out.printf("=========>%s%n", hello); // 显示调用结果
    }
}
