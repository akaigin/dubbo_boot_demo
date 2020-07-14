package com.akai.consumer.services;

import com.akai.common.services.ConsumeDemoService;
import com.akai.common.services.PrintDemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ConsumeDemoServiceImpl implements ConsumeDemoService {
    @Reference
    private PrintDemoService printDemoService;

    public void print(){
        printDemoService.print();
    }
}
