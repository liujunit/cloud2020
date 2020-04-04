package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String getPaymentOk(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String getPaymentTimeOut(@PathVariable("id") Integer id) {
//        int age = 10 / 0;
        return paymentHystrixService.paymentTimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "客户端调用返回》》》系统繁忙，运行报错请稍后再试 paymentInfo_TimeOutHandler, id:" + id + "\t" + "o(╥﹏╥)o~";
    }

    public String paymentInfo_Global_FallbackMethod() {
        return "Global>>>全局fallback方法o》》》(╥﹏╥)o";
    }
}
