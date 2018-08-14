package com.cunjunwang.order.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

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

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}
