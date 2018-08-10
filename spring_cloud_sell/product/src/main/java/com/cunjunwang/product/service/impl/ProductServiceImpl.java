package com.cunjunwang.product.service.impl;

import com.cunjunwang.product.dataobject.ProductInfo;
import com.cunjunwang.product.enums.ProductStatusEnum;
import com.cunjunwang.product.repository.ProductInfoRepository;
import com.cunjunwang.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
