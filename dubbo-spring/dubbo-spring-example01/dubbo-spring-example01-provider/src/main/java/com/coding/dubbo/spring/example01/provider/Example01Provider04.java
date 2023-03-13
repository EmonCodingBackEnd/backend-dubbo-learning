package com.coding.dubbo.spring.example01.provider;

import java.io.IOException;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import com.coding.dubbo.spring.example01.api.HelloService;
import com.coding.dubbo.spring.example01.provider.impl.HelloServiceImpl;

// 【注意：注册失败】
public class Example01Provider04 {

    public static void main(String[] args) throws IOException {
        // 服务实现
        HelloService helloService = new HelloServiceImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-spring-example01-provider");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://emon:2181");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        protocol.setThreads(200);

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
        // 服务提供者暴露服务配置
        ServiceConfig<HelloService> service = new ServiceConfig<>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄露
        service.setApplication(application);
        service.setRegistry(registry);
        service.setProtocol(protocol);

        service.setInterface(HelloService.class);
        service.setRef(helloService);
        service.setVersion("V1.0.0");

        // 暴露及注册服务
        service.export();
        // 挂起等待(防止进程退出）
        System.in.read();
    }
}
