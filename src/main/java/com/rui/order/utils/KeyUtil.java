package com.rui.order.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一的主键,当前时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
