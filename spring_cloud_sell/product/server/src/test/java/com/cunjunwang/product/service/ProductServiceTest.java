package com.cunjunwang.product.service;

import com.cunjunwang.product.ProductApplicationTests;
import com.cunjunwang.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findList() {
        List<ProductInfo> productInfoList = productService.findList(Arrays.asList("123456", "4234"));
        Assert.assertTrue(productInfoList.size() > 0);
    }

}