package com.jiang.test;

import com.jiang.fallback.EchoServiceFallback;
import com.jiang.fallback.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * 远程调用
 */
@FeignClient(name = "nacos-jiang-consume", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface TestFeign {

    @GetMapping(value = "/test")
    String test(@RequestParam(value = "str") String str);
}
