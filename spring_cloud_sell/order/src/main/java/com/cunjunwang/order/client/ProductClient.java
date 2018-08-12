package com.cunjunwang.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by CunjunWang on 2018/8/12.
 */

@Component
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @GetMapping("/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productidList);

}

