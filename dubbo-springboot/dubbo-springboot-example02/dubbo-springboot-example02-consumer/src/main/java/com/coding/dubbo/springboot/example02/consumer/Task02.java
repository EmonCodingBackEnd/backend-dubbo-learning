package com.coding.dubbo.springboot.example02.consumer;

import java.util.Date;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.coding.dubbo.springboot.example02.api.HelloService;

@Profile(value = "02")
@Component
public class Task02 implements CommandLineRunner {

    @DubboReference(version = "V1.0.0")
    private HelloService helloService;

    @Override
    public void run(String... args) throws Exception {
        String result = helloService.sayHello("world");
        System.out.println("Receive result ======>" + result);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    // 1.普通
                    System.out.println(new Date() + "Receive result ======>" + helloService.sayHello("world"));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

    }
}
