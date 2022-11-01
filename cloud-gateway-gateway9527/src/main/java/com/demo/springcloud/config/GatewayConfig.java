package com.demo.springcloud.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route_atguigu", r -> r.path("/guonei")
//                        .filters(f -> f.filter(filterFactory.apply()))
                        .uri("http://news.baidu.com/guonei"))
                .build();
    }
}
