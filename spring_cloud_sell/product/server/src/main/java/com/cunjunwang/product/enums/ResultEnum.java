package com.cunjunwang.product.enums;

/**
 * Created by CunjunWang on 2018/8/13.
 */

public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "product not exist"),
    PRODUCT_STOCK_ERROR(2, "not enough stock");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
