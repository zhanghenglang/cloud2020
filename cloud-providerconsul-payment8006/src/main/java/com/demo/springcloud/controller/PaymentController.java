package com.demo.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consul")
    public Object discovery(){

        return "springcloud with consul:  "+serverport+"\t"+ UUID.randomUUID().toString();

    }
}
