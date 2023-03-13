package com.coding.dubbo.springboot.example02.api;

import org.apache.dubbo.common.stream.StreamObserver;

public interface HelloService {

    /**
     * 向传入的名字打招呼
     * 
     * @param name
     * @return
     */
    String sayHello(String name);

    /**
     * 客户端流
     * 
     * @param response
     * @return
     */
    default StreamObserver<String> sayHelloServerStream(StreamObserver<String> response) {
        throw new RuntimeException("尚未实现！");
    };

    /**
     * 服务端流
     * 
     * @param name
     * @param response
     */
    default void sayHelloServerStream(String name, StreamObserver<String> response) {
        throw new RuntimeException("尚未实现！");
    }
}
