package com.akai.consumer.Controllers;

import com.akai.common.Services.ConsumeDemoService;
import com.akai.consumer.Rpc.MqProduceRpc;
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
    public void print(){
        consumeDemoService.print();
    }

    @RequestMapping("/send")
    public String send(String msg){
        return mqProduceRpc.produce(msg);
    }
}
