package com.demo.springcloud.alibaba.controller;

import com.demo.springcloud.alibaba.domain.CommonResult;
import com.demo.springcloud.alibaba.domain.Order;
import com.demo.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        order.setId(1L);
        order.setUserId(1L);
        order.setProductId(1L);
        order.setMoney(new BigDecimal(100));
        order.setCount(2);
        order.setStatus(0);

        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
