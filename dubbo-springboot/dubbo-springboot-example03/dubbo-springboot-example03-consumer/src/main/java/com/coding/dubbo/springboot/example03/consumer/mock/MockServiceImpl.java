package com.coding.dubbo.springboot.example03.consumer.mock;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

public class MockServiceImpl implements InterfaceService {

    @Override
    public String sayHello(String name) {
        // 你可以伪造容错数据，此方法只在出现RpcException时被执行
        return "对 " + name + " 调用异常的容错数据";
    }
}
