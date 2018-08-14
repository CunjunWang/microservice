package com.cunjunwang.order.controller;


import com.cunjunwang.order.VO.ResultVO;
import com.cunjunwang.order.converter.OrderForm2OrderDTOConverter;
import com.cunjunwang.order.dto.OrderDTO;
import com.cunjunwang.order.enums.ResultEnum;
import com.cunjunwang.order.exceptions.OrderException;
import com.cunjunwang.order.form.OrderForm;
import com.cunjunwang.order.service.OrderService;
import com.cunjunwang.order.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 1. api参数校验
     * 2. 查询商品信息（调用商品服务）
     * 3. 计算总价
     * 4. 更新库存（调用商品服务）
     * 5. 订单入库
     */

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
//            log.error("[ Error in creating order... ] Invalid Parameter, orderForm = {}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if (orderDTO.getOrderDetailList().isEmpty()) {
//            log.error("[ Error in creating order... ] Shopping cart is empty");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);

    }
}
