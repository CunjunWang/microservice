package com.cunjunwang.product.repository;

import com.cunjunwang.product.dataobject.ProductCategory;
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
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> categories = repository.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertTrue(categories.size() > 0);

    }
}