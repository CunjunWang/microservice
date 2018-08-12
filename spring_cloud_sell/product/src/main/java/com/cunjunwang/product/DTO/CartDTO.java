package com.cunjunwang.product.DTO;

import lombok.Data;

/**
 * Created by CunjunWang on 2018/8/12.
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
