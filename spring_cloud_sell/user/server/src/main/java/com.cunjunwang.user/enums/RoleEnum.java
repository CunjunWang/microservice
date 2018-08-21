package com.cunjunwang.user.enums;

/**
 * Created by CunjunWang on 2018/8/17.
 */


public enum RoleEnum {

    BUYER(1, "buyer"),
    SELLER(2, "seller");

    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
