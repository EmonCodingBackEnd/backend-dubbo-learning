package com.coding.dubbo.springboot.example02.provider.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Profile;

import com.coding.dubbo.springboot.example02.api.HelloService;

@Profile(value = "01")
@DubboService(register = false, version = "V1.0.0")
public class HelloServiceImpl01 implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Provider response Hello " + name;
    }
}
