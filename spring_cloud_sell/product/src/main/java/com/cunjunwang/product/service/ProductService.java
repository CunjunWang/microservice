package com.cunjunwang.product.service;

import com.cunjunwang.product.dataobject.ProductInfo;
import com.cunjunwang.product.dto.CartDTO;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<CartDTO> cartDTOList);

}
