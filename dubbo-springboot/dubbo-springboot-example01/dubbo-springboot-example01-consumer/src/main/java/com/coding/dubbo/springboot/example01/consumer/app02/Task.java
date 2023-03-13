package com.coding.dubbo.springboot.example01.consumer.app02;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coding.dubbo.springboot.example01.api.HelloService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Task implements CommandLineRunner {

    private final HelloService helloService;

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
