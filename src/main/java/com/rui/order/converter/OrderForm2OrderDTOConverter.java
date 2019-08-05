package com.rui.order.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rui.order.datapojo.OrderDetail;
import com.rui.order.dto.OrderDTO;
import com.rui.order.enums.ResultEnum;
import com.rui.order.exception.SellException;
import com.rui.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
//        ObjectMapper mapper = new ObjectMapper();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;
        try {
            orderDetailList =  gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
                                    }.getType());
//            orderDetailList = mapper.readValue(OrderForm.class, OrderDTO.class);
        } catch (Exception e) {
            log.error("[对象转换]错误,string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
