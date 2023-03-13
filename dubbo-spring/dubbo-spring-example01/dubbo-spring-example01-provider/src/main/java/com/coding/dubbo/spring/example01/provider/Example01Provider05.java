package com.coding.dubbo.spring.example01.provider;

import java.io.IOException;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import com.coding.dubbo.spring.example01.api.HelloService;
import com.coding.dubbo.spring.example01.provider.impl.HelloServiceImpl;

public class Example01Provider05 {

    public static void main(String[] args) throws IOException {
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
        ServiceConfig<HelloService> service = new ServiceConfig<>();
        service.setInterface(HelloService.class);
        service.setRef(new HelloServiceImpl());
        service.setVersion("V1.0.0");

        // 通过DubboBootstrap简化配置组装，控制启动过程
        DubboBootstrap.getInstance().application(application) // 应用配置
            .registry(registry) // 注册中心配置
            .protocol(protocol) // 全局默认协议配置
            .service(service) // 添加ServiceConfig
            .start() // 启动Dubbo
            .await(); // 挂起等待(防止进程退出）
    }
}
