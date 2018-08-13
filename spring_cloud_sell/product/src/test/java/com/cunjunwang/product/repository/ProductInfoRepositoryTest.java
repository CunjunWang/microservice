package com.cunjunwang.product.repository;

import com.cunjunwang.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> list = repository.findByProductIdIn(Arrays.asList("123456", "4234"));
        Assert.assertTrue(list.size() > 0);
    }
}