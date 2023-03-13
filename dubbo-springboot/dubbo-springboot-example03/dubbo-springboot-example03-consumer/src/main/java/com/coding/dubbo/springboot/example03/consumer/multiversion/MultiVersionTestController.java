package com.coding.dubbo.springboot.example03.consumer.multiversion;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@RestController
public class MultiVersionTestController {

    @DubboReference(version = "V1.0.0")
    private InterfaceService interfaceService;

    @GetMapping(value = "/consumer/directcall")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }

    @DubboReference(version = "V1.1.0")
    private InterfaceService interfaceService2;

    @GetMapping(value = "/consumer/directcall2")
    public String test2() {
        String result = interfaceService2.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }

    // version = "*" 表示随机调用不同版本的接口
    @DubboReference(version = "*")
    private InterfaceService interfaceServiceWithoutVersion;

    @GetMapping(value = "/consumer/directcall3")
    public String test3() {
        String result = interfaceServiceWithoutVersion.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }
}
