package com.coding.dubbo.springboot.example03.provider.injvm;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coding.dubbo.springboot.example03.api.InterfaceService;

@Component
public class InJVMClient implements CommandLineRunner {

    @DubboReference(version = "V1.0.0", scope = "local")
    private InterfaceService inJvmProvider;

    @Override
    public void run(String... args) throws Exception {
        String result = inJvmProvider.sayHello("world");
        System.out.println("inJvmProvider result ======>" + result);
    }

}
