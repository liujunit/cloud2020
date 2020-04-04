package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentOk(Integer id) {
        return "异常处理----------》paymentOk";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "异常处理----------》paymentTimeOut";
    }
}
