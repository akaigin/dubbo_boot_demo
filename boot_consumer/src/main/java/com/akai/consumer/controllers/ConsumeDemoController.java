package com.akai.consumer.controllers;

import com.akai.common.services.ConsumeDemoService;
import com.akai.consumer.rpc.MqProduceRpc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumeDemoController {
    @Resource
    private ConsumeDemoService consumeDemoService;
    @Resource
    private MqProduceRpc mqProduceRpc;

    @RequestMapping("print")
    public String print(){
        consumeDemoService.print();
        return "success";
    }

    @RequestMapping("/send")
    public String send(String msg){
        return mqProduceRpc.produce(msg);
    }
}
