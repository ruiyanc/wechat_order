package com.rui.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    /*买家状态*/
    NEW(0,"新订单"), FINISHED(1,"完结"), CANCEL(2,"已取消"),;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
