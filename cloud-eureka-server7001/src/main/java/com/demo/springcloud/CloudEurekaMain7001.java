package com.demo.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaMain7001.class,args);
    }
}
