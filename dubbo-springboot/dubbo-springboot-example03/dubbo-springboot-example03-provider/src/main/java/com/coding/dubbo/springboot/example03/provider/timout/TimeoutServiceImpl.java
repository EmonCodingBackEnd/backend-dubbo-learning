package com.coding.dubbo.springboot.example03.provider.timout;

import java.util.concurrent.TimeUnit;

import org.apache.dubbo.config.annotation.DubboService;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@DubboService(version = "V1.0.0")
public class TimeoutServiceImpl implements InterfaceService {

    @Override
    public String sayHello(String name) {
        System.out.println("start execute sayHello ...");
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Provider response Hello " + name;
    }
}
