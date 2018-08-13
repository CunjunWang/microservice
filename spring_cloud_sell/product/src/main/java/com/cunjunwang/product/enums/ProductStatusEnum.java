package com.cunjunwang.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(0, "UP"),
    DOWN(1, "DOWN");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
