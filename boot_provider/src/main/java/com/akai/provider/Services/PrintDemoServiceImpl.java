package com.akai.provider.Services;

import com.akai.common.Services.PrintDemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class PrintDemoServiceImpl implements PrintDemoService {
    public void print(){
        System.out.println("这是一个输出的demo");
    }


}
