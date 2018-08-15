package com.cunjunwang.order.controller;

import com.cunjunwang.order.dto.OrderDTO;
import com.cunjunwang.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CunjunWang on 2018/8/15.
 */

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public String process() {
//        streamClient.output().send(MessageBuilder
//                .withPayload("now " + new Date()).build());
//        return "ok";
//    }

    // 发送OrderDTO对象
    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123123");
        streamClient.outputMessage().send(MessageBuilder
                .withPayload(orderDTO).build());
    }
}
