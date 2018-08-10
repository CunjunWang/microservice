package com.cunjunwang.product.service;

import com.cunjunwang.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
