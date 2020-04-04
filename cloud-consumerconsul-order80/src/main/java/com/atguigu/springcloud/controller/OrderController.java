package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String BROK_URL = "http://consul-provider-payment";

    @GetMapping(value = "/payment/consul")
    public String getPayment() {
        return restTemplate.getForObject(BROK_URL + "/payment/consul", String.class);
    }

}
