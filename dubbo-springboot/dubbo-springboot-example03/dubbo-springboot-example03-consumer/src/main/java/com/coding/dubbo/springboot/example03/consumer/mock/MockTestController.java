package com.coding.dubbo.springboot.example03.consumer.mock;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@RestController
public class MockTestController {

    // 通过设置check = false，启动时不检查提供方服务
    /*// 如果Mock是接口名称+Mock，且package一致，还可以使用 stub = "true"
    @DubboReference(version = "V1.0.0", check = false, mock = "true")*/
    /*// 可以在服务提供方不在线时触发RpcException，继而触发本地Mock服务
    @DubboReference(version = "V1.0.0", check = false,
        mock = "com.coding.dubbo.springboot.example03.consumer.mock.MockServiceImpl")*/
    // @DubboReference(version = "V1.0.0", check = false, mock = "throw")
    // @DubboReference(version = "V1.0.0", check = false, mock = "return empty")
    // @DubboReference(version = "V1.0.0", check = false, mock = "return null")
    // 强制调用mock，哪怕服务提供者可用
    @DubboReference(version = "V1.0.0", check = false, mock = "force:return 一直反馈容错信息")
    private InterfaceService interfaceService;

    @GetMapping(value = "/consumer/mock")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }

}
