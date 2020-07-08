package com.akai.consumer.Controllers;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RocketMQMessageListener(consumerGroup = "my-consumer_test-topic", topic = "test-topic")
public class MqConsumeController implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg){
        System.out.println("接收到了消息："+msg);
    }

}
