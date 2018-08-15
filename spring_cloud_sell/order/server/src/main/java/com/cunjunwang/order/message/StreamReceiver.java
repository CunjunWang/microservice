package com.cunjunwang.order.message;

import com.cunjunwang.order.dto.OrderDTO;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by CunjunWang on 2018/8/15.
 */

@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

//    @StreamListener("myMessage1")
//    public void process(String message) {
//        System.out.println("StreamReceiver: " + message);
//    }

    // 接收orderDTO对象
//    @StreamListener("myMessage")
//    public void process(OrderDTO message) {
//        System.out.println("StreamReceiver: " + message);
//    }

    @StreamListener(value = StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO message) {
        System.out.println("StreamReceiver: " + message);

        return "Receiver: received.";
    }

    @StreamListener(value = StreamClient.INPUT2)
    public void process2(String message) {
        System.out.println("StreamReceiver2: " + message);
    }

}
