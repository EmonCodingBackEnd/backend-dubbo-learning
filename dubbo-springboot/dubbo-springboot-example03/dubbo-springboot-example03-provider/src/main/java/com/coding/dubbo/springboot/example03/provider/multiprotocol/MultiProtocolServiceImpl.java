package com.coding.dubbo.springboot.example03.provider.multiprotocol;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@DubboService(version = "V1.0.0")
public class MultiProtocolServiceImpl implements InterfaceService {

    @Override
    @DubboService(protocol = "dubboId")
    public String sayHello(String name) {
        System.out.println("start execute sayHello ...");
        return "Provider response Hello " + name;
    }

    @Override
    @DubboService(protocol = "triId")
    public StreamObserver<String> sayHelloServerStream(StreamObserver<String> response) {
        return new StreamObserver<String>() {
            @Override
            public void onNext(String data) {
                System.out.println("接收到客户端结果:" + data);
                response.onNext("hello," + data);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("接收到客户端错误:" + throwable.getMessage());
                response.onError(new RuntimeException("芭比Q了！"));
            }

            @Override
            public void onCompleted() {
                System.out.println("接收到客户端已完成通知");
                response.onCompleted();
            }
        };
    }

    @Override
    @DubboService(protocol = "triId")
    public void sayHelloServerStream(String name, StreamObserver<String> response) {
        // 处理name
        response.onNext("hello1:" + name);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        response.onNext("hello2:" + name);
        response.onCompleted();
    }
}
