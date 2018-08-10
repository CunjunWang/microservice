package com.cunjunwang.order.service.impl;

import com.cunjunwang.order.dataobject.OrderMaster;
import com.cunjunwang.order.dto.OrderDTO;
import com.cunjunwang.order.enums.OrderStatusEnum;
import com.cunjunwang.order.enums.PaymentStatusEnum;
import com.cunjunwang.order.repository.OrderDetailRepository;
import com.cunjunwang.order.repository.OrderMasterRepository;
import com.cunjunwang.order.service.OrderService;
import com.cunjunwang.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.getUniqueKey());

        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPaymentStatus(PaymentStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
