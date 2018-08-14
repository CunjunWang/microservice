package com.cunjunwang.order.form;

import javax.validation.constraints.NotEmpty;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
