package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign日志级别
 * NONE：默认的，不显示任何日志
 * BASE：仅记录请求方法、URL、相应状态码、请求时间
 * HEADERS：除了BASE中定义的信息之外，还有请求头和响应头的信息
 * FULL：除了HEADERS中定义的信息之外，还有请求体和响应体的信息
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
