package com.coding.dubbo.springboot.example03.consumer.dubbo_xml;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DubboXmlTestController {

    private final InterfaceService interfaceService;

    @GetMapping(value = "/consumer/dubbo_xml")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }
}
