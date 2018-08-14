package com.cunjunwang.product.common;

import java.math.BigDecimal;

/**
 * Created by CunjunWang on 2018/8/14.
 */
public class ProductInfoOutput {

    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    public String getProductId() {
        return productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }
}