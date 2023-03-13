package com.coding.dubbo.springboot.example03.consumer.stub;

import org.springframework.util.ObjectUtils;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StubServiceImpl implements InterfaceService {

    // 被自动传入远程代理对象
    private final InterfaceService interfaceService;

    @Override
    public String sayHello(String name) {
        if (!ObjectUtils.isEmpty(name)) {
            return interfaceService.sayHello(name);
        }
        return null;
    }
}
