package com.rui.order.service;

import com.rui.order.datapojo.SellerInfo;

public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
