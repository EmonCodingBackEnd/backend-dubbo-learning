package com.coding.dubbo.spring.example01.consumer;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coding.dubbo.spring.example01.api.HelloService;

public class Example01Consumer01 {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"example01-consumer01.xml"});
        context.start();

        HelloService helloService = context.getBean("consumerHelloService", HelloService.class); // 获取远程服务代理
        String hello = helloService.sayHello("world"); // 执行远程方法
        System.out.printf("=========>%s%n", hello); // 显示调用结果
    }
}
