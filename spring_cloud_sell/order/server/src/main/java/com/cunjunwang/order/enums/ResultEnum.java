package com.cunjunwang.order.enums;

public enum ResultEnum {

    PARAM_ERROR(1, "parameter error"),
    CART_EMPTY(2, "Cart is empty"),
    ORDER_NOT_EXIST(3, "Order does not exist"),
    ORDER_STATUS_ERROR(4, "Order status error"),
    ORDER_DETAIL_NOT_EXIST(5, "Order detail not exist");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
