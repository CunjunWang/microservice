package com.cunjunwang.order.enums;

import lombok.Getter;

@Getter
public enum PaymentStatusEnum {

    WAIT(0, "unpaid"), SUCCESS(1, "paid");

    private Integer code;

    private String message;

    PaymentStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
