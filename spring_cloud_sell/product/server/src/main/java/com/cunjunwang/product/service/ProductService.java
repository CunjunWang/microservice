package com.cunjunwang.product.service;

import com.cunjunwang.product.common.DecreaseStockInput;
import com.cunjunwang.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
