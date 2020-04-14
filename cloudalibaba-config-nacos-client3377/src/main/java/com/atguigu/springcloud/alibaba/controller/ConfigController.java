package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //支持Nacos的自动刷新
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/nacos/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

}
