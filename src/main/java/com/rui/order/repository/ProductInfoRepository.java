package com.rui.order.repository;

import com.rui.order.datapojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String > {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
