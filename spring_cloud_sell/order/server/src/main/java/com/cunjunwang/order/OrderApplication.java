package com.cunjunwang.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication
// @EnableDiscoveryClient
// @EnableCircuitBreaker
// 这三个包含在 @SpringCloudApplication

@SpringCloudApplication
@ComponentScan(basePackages = "com.cunjunwang")
@EnableFeignClients(basePackages = "com.cunjunwang.product.client")
@EnableHystrixDashboard
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
