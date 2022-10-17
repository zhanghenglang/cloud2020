package com.demo.springcloud.dao;

import com.demo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id")Long id);
}
