package com.rui.order.service.impl;

import com.rui.order.datapojo.SellerInfo;
import com.rui.order.repository.SellerInfoRepository;
import com.rui.order.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
