package com.rui.order.datapojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "product_info")
public class ProductInfo {
    @Id
    @Column(name = "product_id")
    private String productId;
    /** 名字*/
    @Column(name = "product_name")
    private String productName;
    /** 单价*/
    @Column(name = "product_price")
    private BigDecimal productPrice;
    /** 库存*/
    @Column(name = "product_stock")
    private Integer productStock;
    /** 描述*/
    @Column(name = "product_description")
    private String productDescription;
    /** 小图*/
    @Column(name = "product_icon")
    private String productIcon;
    /** 状态0正常1下架*/
    @Column(name = "product_status")
    private Integer productStatus;
    /** 类目编号*/
    @Column(name = "category_type")
    private Integer categoryType;
//    private Date createTime;
//    private Date updateTime;

    public ProductInfo() {
    }
}
