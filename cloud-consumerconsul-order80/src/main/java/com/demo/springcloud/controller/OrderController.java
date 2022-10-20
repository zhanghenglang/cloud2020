package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consul",method = RequestMethod.GET)
    public String getPaymentById(){

        return  restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
