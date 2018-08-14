package com.cunjunwang.order.converter;

import com.cunjunwang.order.dataobject.OrderDetail;
import com.cunjunwang.order.dto.OrderDTO;
import com.cunjunwang.order.enums.ResultEnum;
import com.cunjunwang.order.exceptions.OrderException;
import com.cunjunwang.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {

        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;

        try {
            orderDetailList = gson.fromJson(
                    orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
//            log.error("[ Error in Json convertion ], string = {}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
