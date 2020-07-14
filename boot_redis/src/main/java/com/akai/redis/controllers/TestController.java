package com.akai.redis.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @RequestMapping("print")
    public void print(){
        System.out.println("这是一个redis的demo");
    }
}
