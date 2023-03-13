package com.coding.dubbo.springboot.example03.consumer.stub;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@RestController
public class StubTestController {

    /*// 如果Stub是接口名称+Stub，且package一致，还可以使用 stub = "true"
    @DubboReference(version = "V1.0.0", stub = "true")*/
    @DubboReference(version = "V1.0.0", stub = "com.coding.dubbo.springboot.example03.consumer.stub.StubServiceImpl")
    private InterfaceService interfaceService;

    @GetMapping(value = "/consumer/stub")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }

    @GetMapping(value = "/consumer/stub2")
    public String test2() {
        String result = interfaceService.sayHello("");
        System.out.println("Receive result ======>" + result);
        return result;
    }

}
