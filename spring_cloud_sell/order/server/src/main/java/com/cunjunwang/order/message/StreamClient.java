package com.cunjunwang.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * Created by CunjunWang on 2018/8/15.
 */

@Component
public interface StreamClient {

//    String INPUT = "myMessage";

//    @Input("myMessage")
//    SubscribableChannel input();
//
//    @Output("myMessageOutput")
//    MessageChannel output();

    String INPUT = "myInput";
    String OUTPUT = "myOutput";

    @Input(StreamClient.INPUT)
    SubscribableChannel inputMessage();

    @Output(StreamClient.OUTPUT)
    MessageChannel outputMessage();

    String INPUT2 = "myInput2";
    String OUTPUT2 = "myOutput2";

    @Input(StreamClient.INPUT2)
    SubscribableChannel inputMessage2();

    @Output(StreamClient.OUTPUT2)
    MessageChannel outputMessage2();

}
