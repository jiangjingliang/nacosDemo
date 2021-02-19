package com.jiang.contr;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("消费者模块")
public class ConsumerTestContr {

    @GetMapping("/test")
    @ApiOperation("消费测试")
    public Object test(@RequestParam(value = "str") String str){
        return "ConsumerTestContr feign success!"+str;
    }
}
