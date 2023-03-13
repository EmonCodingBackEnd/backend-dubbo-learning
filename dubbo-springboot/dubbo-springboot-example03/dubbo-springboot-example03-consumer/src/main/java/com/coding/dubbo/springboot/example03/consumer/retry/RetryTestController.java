package com.coding.dubbo.springboot.example03.consumer.retry;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@RestController
public class RetryTestController {

    /*
     * 幂等【查询、删除、修改】可以设置重试次数，非幂等【新增】不应该设置重试次数。
     * 设置retries = 0表示不需要重试；默认的retries为2，表示除了首次调用之外，会重试2次。
     * 【重点】服务提供者是Dubbo协议，才会触发重试，默认的tri协议不会。
     */
    @DubboReference(version = "V1.0.0", timeout = 1500, retries = 1)
    private InterfaceService interfaceService;

    @GetMapping(value = "/consumer/retry")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }
}
