package com.akai.provider.services;

import com.akai.common.services.PrintDemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class PrintDemoServiceImpl implements PrintDemoService {
    public void print(){
        System.out.println("这是一个输出demo");
    }
}
