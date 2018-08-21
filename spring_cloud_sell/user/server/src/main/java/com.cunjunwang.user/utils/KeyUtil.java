package com.cunjunwang.user.utils;

import java.util.Random;

public class KeyUtil {

    // 避免多线程生成同样的订单号
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
