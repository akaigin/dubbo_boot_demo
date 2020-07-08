package com.akai.consumer.Rpc;

import com.akai.common.Services.MqDemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class MqProduceRpc {

    //此处Reference是dubbo库中的，并非Springframework的
    @Reference
    private MqDemoService mqDemoService;

    public String produce(String msg){
        return mqDemoService.produce(msg);
    }
}
