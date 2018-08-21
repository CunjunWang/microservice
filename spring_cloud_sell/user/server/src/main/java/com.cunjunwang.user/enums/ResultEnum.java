package com.cunjunwang.user.enums;

public enum ResultEnum {

    LOGIN_FAILED(1, "Login Failed"),
    ROLE_ERROR(2, "Role error");

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
