package com.coding.dubbo.springboot.example03.consumer.check;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@RestController
public class CheckTestController {

    @DubboReference(version = "V1.0.0", check = false)
    private InterfaceService interfaceService;

    @GetMapping(value = "/consumer/check")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }
}
