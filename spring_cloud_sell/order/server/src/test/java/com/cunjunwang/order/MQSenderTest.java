package com.cunjunwang.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by CunjunWang on 2018/8/15.
 */

@Component
public class MQSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void senderTest() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

    @Test
    public void senderOrder() {
        amqpTemplate.convertAndSend("myOrder", "computer", "now " + new Date());
    }

}
