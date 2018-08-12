package com.cunjunwang.product.enums;

import lombok.Getter;

/**
 * Created by CunjunWang on 2018/8/12.
 */

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "Product not exist"),
    PRODUCT_STOCK_ERROR(2, "Error in stock");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
