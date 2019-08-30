package com.rui.order.service;

import com.rui.order.datapojo.ProductInfo;
import com.rui.order.dto.CartDTO;
import com.rui.order.exception.SellException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**加库存*/
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList) throws SellException;

    /**上架*/
    ProductInfo onSale(String productId);
    /**下架*/
    ProductInfo offSale(String productId);
}
