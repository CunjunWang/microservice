package com.cunjunwang.order.controller;

import com.cunjunwang.order.config.TrnConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CunjunWang on 2018/8/14.
 */

@RestController
public class TrnController {

    @Autowired
    private TrnConfig trnConfig;

    @GetMapping("/trn/print")
    public String print() {
        return "name: " + trnConfig.getName() + " age: " + trnConfig.getAge();
    }
}
