package com.coding.dubbo.spring.example01.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example01Provider03 {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"example01-provider03.xml"});
        context.start();
        System.in.read(); // 按下任意键退出
    }
}
