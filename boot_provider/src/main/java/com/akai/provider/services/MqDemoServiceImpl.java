package com.akai.provider.services;

import com.akai.common.services.MqDemoService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

import javax.annotation.Resource;

@Service(timeout = 5000,retries = 5)
public class MqDemoServiceImpl implements MqDemoService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public String produce(String msg){
        rocketMQTemplate.convertAndSend("test-topic",msg);
        return "success";
    }
}
