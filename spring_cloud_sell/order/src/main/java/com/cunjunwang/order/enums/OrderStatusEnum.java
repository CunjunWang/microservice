package com.cunjunwang.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    NEW(0, "new"), FINISHED(1, "finished"), CANCELLED(2, "cancelled");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
