package com.demo.springcloud.controller;

import com.demo.springcloud.config.ApplicationContexConfig;
import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import com.demo.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class OrderController {
//    public static final String PAYMENT_URL="http://127.0.0.1:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/getPaymentById/{id}",method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){

        return  restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    @RequestMapping(value = "/getForEntity/{id}",method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById2(@PathVariable Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }


    @RequestMapping(value = "/getPaymentLB",method = RequestMethod.GET)
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances==null&&instances.size()<=0){
            return null;
        }
        ServiceInstance instances1 = loadBalancer.instances(instances);
        URI uri = instances1.getUri();

        return  restTemplate.getForObject(uri+"/payment/getPaymentLB",String.class);
    }
}
