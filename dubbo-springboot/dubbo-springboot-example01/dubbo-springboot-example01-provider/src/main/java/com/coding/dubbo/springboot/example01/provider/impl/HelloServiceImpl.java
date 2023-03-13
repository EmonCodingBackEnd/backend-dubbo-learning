package com.coding.dubbo.springboot.example01.provider.impl;

import com.coding.dubbo.springboot.example01.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Provider response Hello " + name;
    }
}
