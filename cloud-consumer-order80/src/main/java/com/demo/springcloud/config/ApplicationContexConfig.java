package com.demo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContexConfig {

    @Bean
    //@LoadBalanced   //使用ribbon的负载均衡注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
