package com.cunjunwang.product.exception;

import com.cunjunwang.product.enums.ResultEnum;

/**
 * Created by CunjunWang on 2018/8/13.
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
