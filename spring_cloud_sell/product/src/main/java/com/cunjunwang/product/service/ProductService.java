package com.cunjunwang.product.service;

import com.cunjunwang.product.DTO.CartDTO;
import com.cunjunwang.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll();

    /**
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);


    void decreaseStock(List<CartDTO> cartDTOList);
}
