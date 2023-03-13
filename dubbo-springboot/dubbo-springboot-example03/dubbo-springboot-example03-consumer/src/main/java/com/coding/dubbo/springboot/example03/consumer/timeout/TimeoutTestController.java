package com.coding.dubbo.springboot.example03.consumer.timeout;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@RestController
public class TimeoutTestController {

    @DubboReference(version = "V1.0.0", timeout = 1500, methods = @Method(name = "sayHello", timeout = 3000))
    private InterfaceService interfaceService;

    @GetMapping(value = "/consumer/timeout")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }
}
