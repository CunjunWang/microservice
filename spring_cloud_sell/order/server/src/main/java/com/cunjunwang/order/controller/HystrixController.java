package com.cunjunwang.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by CunjunWang on 2018/8/21.
 */

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    // 超时配置
    // @HystrixCommand(commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    // })

    // 熔断
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true" ),    // 设置熔断
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//    })
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfo() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8082/product/listForOrder",
                Arrays.asList("123456"),
                String.class);

    }

    private String fallback() {
        return "Too many services. Please try again later.";
    }

    private String defaultFallback() {
        return "******Too many services. Please try again later.******";
    }
}
