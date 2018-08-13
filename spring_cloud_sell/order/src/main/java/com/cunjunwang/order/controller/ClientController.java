package com.cunjunwang.order.controller;

import com.cunjunwang.order.client.ProductClient;
import com.cunjunwang.order.dataobject.ProductInfo;
import com.cunjunwang.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {

        String response = productClient.productMsg();
        log.info("response = {}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("123456"));
        log.info("response={}", productInfoList);
        return "ok";
    }

//        // 第一种方式 直接用restTemplate. url hard code
//        // RestTemplate restTemplate = new RestTemplate();
//        // String response = restTemplate.getForObject("http://localhost:8080", String.class);
//
//        // 第二种方式 用LoadBalancerClient 通过应用名获取url 然后再用restTemplate
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
//        String response = restTemplate.getForObject(url, String.class);
//        log.info("response = {}", response);
//
//        // 第三种方式 把RestTemplate配置为Bean, 利用@LoadBalanced
////        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
////


    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("123456", 6)));
        return "Stock updated!";
    }
}
