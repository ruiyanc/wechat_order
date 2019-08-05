package com.rui.order.controller;

import com.rui.order.VO.ResultVO;
import com.rui.order.converter.OrderForm2OrderDTOConverter;
import com.rui.order.dto.OrderDTO;
import com.rui.order.enums.ResultEnum;
import com.rui.order.exception.SellException;
import com.rui.order.form.OrderForm;
import com.rui.order.service.OrderService;
import com.rui.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    /**创建订单
     * @return 状态 */
    @PostMapping("create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        Map<String, String> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            log.error("[创建订单]参数不正确,orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[创建订单]购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }
}
