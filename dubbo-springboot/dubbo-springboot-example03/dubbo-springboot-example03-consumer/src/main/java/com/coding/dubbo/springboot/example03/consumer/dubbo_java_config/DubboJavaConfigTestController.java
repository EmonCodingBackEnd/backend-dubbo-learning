package com.coding.dubbo.springboot.example03.consumer.dubbo_java_config;

import org.apache.dubbo.config.ReferenceConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DubboJavaConfigTestController {

    private final ReferenceConfig<InterfaceService> reference;

    @GetMapping(value = "/consumer/dubbo_java_config")
    public String test() {
        String result = reference.get().sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }
}
