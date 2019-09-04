package com.rui.order.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = -5767014655058101499L;
    /**错误码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**具体内容*/
    private T data;
}
