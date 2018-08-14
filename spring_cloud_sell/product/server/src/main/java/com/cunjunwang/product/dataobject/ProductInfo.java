package com.cunjunwang.product.dataobject;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductId() {
        return productId;
    }
}
