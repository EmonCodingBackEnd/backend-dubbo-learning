package com.coding.dubbo.springboot.example02.provider.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Profile;

import com.coding.dubbo.springboot.example02.api.HelloService;

@Profile(value = "03")
@DubboService(version = "V1.0.0")
public class HelloServiceImpl03 implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Provider response Hello " + name;
    }
}
