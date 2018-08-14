package com.cunjunwang.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CunjunWang on 2018/8/13.
 */

@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is a message";
    }
}
