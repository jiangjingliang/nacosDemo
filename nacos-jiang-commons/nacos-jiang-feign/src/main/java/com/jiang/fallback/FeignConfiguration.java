package com.jiang.fallback;

import org.springframework.context.annotation.Bean;

/***
 * 初始化降级类
 */
public class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

}
