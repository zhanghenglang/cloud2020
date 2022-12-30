package com.demo.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.demo.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
