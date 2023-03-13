package com.coding.dubbo.springboot.example03.provider.mock;

import org.apache.dubbo.config.annotation.DubboService;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@DubboService(version = "V1.0.0")
public class MockServiceImpl implements InterfaceService {

    @Override
    public String sayHello(String name) {
        System.out.println("start execute sayHello ...");
        return "Provider response Hello " + name;
    }
}
