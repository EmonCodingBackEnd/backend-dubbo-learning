package com.coding.dubbo.springboot.example03.api;

import org.apache.dubbo.common.stream.StreamObserver;

public interface InterfaceService {

    /**
     * 向传入的名字打招呼
     * 
     * @param name
     * @return
     */
    default String sayHello(String name) {
        throw new RuntimeException("未实现的接口方法！");
    }

    /**
     * 双端流
     *
     * @param response
     * @return
     */
    default StreamObserver<String> sayHelloServerStream(StreamObserver<String> response) {
        throw new RuntimeException("未实现的接口方法！");
    }

    /**
     * 服务端流
     *
     * @param name
     * @param response
     */
    default void sayHelloServerStream(String name, StreamObserver<String> response) {
        throw new RuntimeException("未实现的接口方法！");
    }

}
