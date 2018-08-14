package com.cunjunwang.order.enums;

public enum PaymentStatusEnum {

    WAIT(0, "unpaid"), SUCCESS(1, "paid");

    private Integer code;

    private String message;

    PaymentStatusEnum(Integer code, String message) {
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
