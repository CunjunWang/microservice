package com.cunjunwang.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerOpenid;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer paymentStatus;

    private Date createTime;

    private Date updateTime;

}
