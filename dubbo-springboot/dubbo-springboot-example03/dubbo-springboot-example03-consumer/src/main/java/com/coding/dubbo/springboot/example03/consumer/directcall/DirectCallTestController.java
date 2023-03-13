package com.coding.dubbo.springboot.example03.consumer.directcall;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@RestController
public class DirectCallTestController {

    // @DubboReference(version = "V1.0.0", url = "dubbo://localhost:20880")
    @DubboReference(version = "V1.0.0", url = "tri://localhost:50051")
    private InterfaceService interfaceService;

    @GetMapping(value = "/consumer/directcall")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }
}
