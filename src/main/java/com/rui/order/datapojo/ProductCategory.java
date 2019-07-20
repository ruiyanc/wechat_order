package com.rui.order.datapojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;
    /** 类目名字*/
    private String categoryName;
    /** 类目类型编号*/
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}
