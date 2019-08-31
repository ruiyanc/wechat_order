package com.rui.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryForm {

    private Integer categoryId;
    /** 类目名字*/
    private String categoryName;
    /** 类目类型编号*/
    private Integer categoryType;
}
