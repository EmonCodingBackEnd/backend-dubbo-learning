package com.coding.dubbo.spring.example01.provider.impl;

import com.coding.dubbo.spring.example01.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
