package com.coding.dubbo.springboot.example03.provider.dubbo_java_config;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

public class DubboJavaConfigServiceImpl implements InterfaceService {

    @Override
    public String sayHello(String name) {
        System.out.println("start execute sayHello ...");
        return "Provider response Hello " + name;
    }
}
