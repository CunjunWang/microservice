package com.cunjunwang.order.message;

import org.springframework.stereotype.Component;

/**
 * Created by CunjunWang on 2018/8/15.
 */

@Component
public class MQReceiver {

//  1. @RabbitListener(queues = {"myQueue"}) 要先手动建好队列
//  2. 自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
//  3. 自动创建队列，exchange和queue自动绑定
//    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"),
//            exchange = @Exchange("myExchange")))
//    public void process(String message) {
//        System.out.println("MQ Receiver: " + message);
//    }
//
//    // 数码供应商服务 接收消息
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("computerOrder"),
//            exchange = @Exchange("myOrder"),
//            key = "computer"))
//    public void processComputer(String message) {
//        System.out.println("computer MQ Receiver: " + message);
//    }
//
//    // 水果供应商服务 接收消息
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("fruitOrder"),
//            exchange = @Exchange("myOrder"),
//            key = "fruit"))
//    public void processFruit(String message) {
//        System.out.println("fruit MQ Receiver: " + message);
//    }

}
