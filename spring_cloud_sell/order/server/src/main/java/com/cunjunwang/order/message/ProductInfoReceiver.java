package com.cunjunwang.order.message;

import com.cunjunwang.order.utils.JsonUtil;
import com.cunjunwang.product.common.ProductInfoOutput;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by CunjunWang on 2018/8/15.
 */

@Component
public class ProductInfoReceiver {

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        // message => ProductInfoOutput
        ProductInfoOutput productInfoOutput = (ProductInfoOutput) JsonUtil.fromJson(message, ProductInfoOutput.class);
    }

    // 存储消息到Redis
}
