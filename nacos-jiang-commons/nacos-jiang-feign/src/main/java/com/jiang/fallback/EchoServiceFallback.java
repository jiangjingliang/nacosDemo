package com.jiang.fallback;

import com.jiang.test.TestFeign;

/***
 * 降级类
 */
public class EchoServiceFallback implements TestFeign {


    @Override
    public String test(String str) {
        return "test fallback";
    }
}
