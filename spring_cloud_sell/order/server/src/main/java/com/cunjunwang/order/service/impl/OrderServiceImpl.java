package com.cunjunwang.order.service.impl;

import com.cunjunwang.order.dataobject.OrderDetail;
import com.cunjunwang.order.dataobject.OrderMaster;
import com.cunjunwang.order.dto.OrderDTO;
import com.cunjunwang.order.enums.OrderStatusEnum;
import com.cunjunwang.order.enums.PaymentStatusEnum;
import com.cunjunwang.order.repository.OrderDetailRepository;
import com.cunjunwang.order.repository.OrderMasterRepository;
import com.cunjunwang.order.service.OrderService;
import com.cunjunwang.order.utils.KeyUtil;
import com.cunjunwang.product.client.ProductClient;
import com.cunjunwang.product.common.DecreaseStockInput;
import com.cunjunwang.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

//import com.cunjunwang.product.client.ProductClient;
//import com.cunjunwang.product.common.DecreaseStockInput;
//import com.cunjunwang.product.common.ProductInfoOutput;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        // 查询商品信息
        String orderId = KeyUtil.getUniqueKey();
        List<String> productIdList = orderDTO.getOrderDetailList()
                .stream().map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(productIdList);

        // 计算总价

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {

            for(ProductInfoOutput productInfoOutput : productInfoOutputList) {
                if(productInfoOutput.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfoOutput.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);

                    BeanUtils.copyProperties(productInfoOutput, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.getUniqueKey());
                    // 订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // 扣库存
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);

        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPaymentStatus(PaymentStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}