package com.cunjunwang.order.dto;

import com.cunjunwang.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
// 数据传输对象
public class OrderDTO {

    private String orderId;

    private String buyerOpenid;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer paymentStatus;

    private List<OrderDetail> orderDetailList;

}
