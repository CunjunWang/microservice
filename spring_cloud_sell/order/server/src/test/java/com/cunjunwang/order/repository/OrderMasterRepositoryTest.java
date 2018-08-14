package com.cunjunwang.order.repository;

import com.cunjunwang.order.OrderApplicationTests;
import com.cunjunwang.order.dataobject.OrderMaster;
import com.cunjunwang.order.enums.OrderStatusEnum;
import com.cunjunwang.order.enums.PaymentStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setOrderId("394879028140");
        orderMaster.setBuyerName("Jack");
        orderMaster.setBuyerPhone("128714891083");
        orderMaster.setBuyerAddress("SAIC");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(22.2));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPaymentStatus(PaymentStatusEnum.WAIT.getCode());


        OrderMaster result = orderMasterRepository.save(orderMaster);

        Assert.assertNotNull(result);
    }

}