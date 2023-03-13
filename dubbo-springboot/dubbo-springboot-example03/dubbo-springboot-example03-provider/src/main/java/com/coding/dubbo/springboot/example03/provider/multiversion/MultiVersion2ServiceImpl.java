package com.coding.dubbo.springboot.example03.provider.multiversion;

import org.apache.dubbo.config.annotation.DubboService;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@DubboService(version = "V1.1.0")
public class MultiVersion2ServiceImpl implements InterfaceService {

    @Override
    public String sayHello(String name) {
        System.out.println("start execute sayHello2 ...");
        return "Provider response Hello2 " + name;
    }

}
