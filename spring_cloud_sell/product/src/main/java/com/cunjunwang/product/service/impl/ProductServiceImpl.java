package com.cunjunwang.product.service.impl;

import com.cunjunwang.product.DTO.CartDTO;
import com.cunjunwang.product.dataobject.ProductInfo;
import com.cunjunwang.product.enums.ProductStatusEnum;
import com.cunjunwang.product.enums.ResultEnum;
import com.cunjunwang.product.exceptions.ProductException;
import com.cunjunwang.product.repository.ProductInfoRepository;
import com.cunjunwang.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            if(!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productionInfo = productInfoOptional.get();
            Integer result = productionInfo.getProductStock() - cartDTO.getProductQuantity();

            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productionInfo.setProductStock(result);
            productInfoRepository.save(productionInfo);

        }
    }


}
