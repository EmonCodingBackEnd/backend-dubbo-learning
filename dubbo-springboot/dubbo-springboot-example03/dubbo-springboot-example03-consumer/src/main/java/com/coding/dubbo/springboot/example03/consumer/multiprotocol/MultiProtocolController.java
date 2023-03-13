package com.coding.dubbo.springboot.example03.consumer.multiprotocol;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@RestController
public class MultiProtocolController {

    /*
     * 幂等【查询、删除、修改】可以设置重试次数，非幂等【新增】不应该设置重试次数。
     * 设置retries = 0表示不需要重试；默认的retries为2，表示除了首次调用之外，会重试2次。
     * 【重点】服务提供者是Dubbo协议，才会触发重试，默认的tri协议不会。
     */
    @DubboReference(version = "V1.0.0", timeout = 1500, retries = 1, protocol = "dubbo")
    private InterfaceService interfaceService;

    @GetMapping(value = "/consumer/multiprotocol")
    public String test() {
        String result = interfaceService.sayHello("world");
        System.out.println("Receive result ======>" + result);
        return result;
    }

    @DubboReference(version = "V1.0.0", protocol = "tri")
    private InterfaceService interfaceService2;

    @GetMapping(value = "/consumer/multiprotocol2")
    public void test2() {
        // 2.双端流
        StreamObserver<String> request = interfaceService2.sayHelloServerStream(new StreamObserver<String>() {
            @Override
            public void onNext(String data) {
                System.out.println("接收到响应结果:" + data);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("接收到响应错误:" + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("接收到响应已完成通知");
            }
        });
        request.onNext("1");
        request.onNext("2");
        request.onCompleted();
    }

    @DubboReference(version = "V1.0.0", protocol = "tri")
    private InterfaceService interfaceService3;

    @GetMapping(value = "/consumer/interfaceService3")
    public void test3() {
        // 3.服务端流
        interfaceService3.sayHelloServerStream("world", new StreamObserver<String>() {
            @Override
            public void onNext(String data) {
                System.out.println("接收到服务端结果:" + data);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("接收到服务端错误:" + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("接收到服务端已完成通知");
            }
        });
    }
}
