package com.cunjunwang.order.repository;

import com.cunjunwang.order.OrderApplicationTests;
import com.cunjunwang.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("13432");
        orderDetail.setOrderId("141231241");
        orderDetail.setProductIcon("dsahfkljflk");
        orderDetail.setProductId("12313");
        orderDetail.setProductName("13840932");
        orderDetail.setProductPrice(new BigDecimal(0.21));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

}