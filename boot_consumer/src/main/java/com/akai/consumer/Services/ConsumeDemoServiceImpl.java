package com.akai.consumer.Services;

import com.akai.common.Services.ConsumeDemoService;
import com.akai.common.Services.PrintDemoService;
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
