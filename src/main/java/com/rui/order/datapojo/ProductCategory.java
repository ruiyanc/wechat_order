package com.rui.order.datapojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Integer categoryId;
    /** 类目名字*/
    @Column(name = "category_name")
    private String categoryName;
    /** 类目类型编号*/
    @Column(name = "category_type")
    private Integer categoryType;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}