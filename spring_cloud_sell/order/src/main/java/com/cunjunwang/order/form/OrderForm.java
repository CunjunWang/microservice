package com.cunjunwang.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "name must not be empty")
    private String name;

    @NotEmpty(message = "phone must not be empty")
    private String phone;

    @NotEmpty(message = "address must not be empty")
    private String address;

    @NotEmpty(message = "openid must not be empty")
    private String openid;

    @NotEmpty(message = "items must not be empty")
    private String items;
}
