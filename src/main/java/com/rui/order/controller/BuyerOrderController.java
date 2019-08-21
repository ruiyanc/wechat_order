package com.rui.order.controller;

import com.rui.order.service.BuyerService;
import com.rui.order.vo.ResultVO;
import com.rui.order.converter.OrderForm2OrderDTOConverter;
import com.rui.order.dto.OrderDTO;
import com.rui.order.enums.ResultEnum;
import com.rui.order.exception.SellException;
import com.rui.order.form.OrderForm;
import com.rui.order.service.OrderService;
import com.rui.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    /**创建订单
     * @return 状态 */
    @PostMapping("create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        Map<String, String> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            log.error("[创建订单]参数不正确,orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
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

    /**订单列表
     * @return*/
    @GetMapping("list")
    public ResultVO list(@RequestParam("openid") String openid,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("[订单查询列表]openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageable);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    /**订单详情
     * @return*/
    @GetMapping("detail")
    public ResultVO detail(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    /**订单取消*/
    @PostMapping("cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }
}
