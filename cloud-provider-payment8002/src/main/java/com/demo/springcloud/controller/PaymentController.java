package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import com.demo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverport;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult<?> create(@RequestBody Payment payment){

        int result=paymentService.create(payment);
        if (result > 0){
            return new CommonResult<>(200,"8002",result);
        }
        return new CommonResult<>(500,"8002");
    }

    @RequestMapping(value = "/getPaymentById/{id}",method = RequestMethod.GET)
    public CommonResult<?> getPaymentById(@PathVariable Long id){

        Payment payment=paymentService.getPaymentById(id);

        return new CommonResult<>(200,"serverport: "+serverport,payment);
    }


    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**********service:   "+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("**********instance:   "+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;

    }
}
