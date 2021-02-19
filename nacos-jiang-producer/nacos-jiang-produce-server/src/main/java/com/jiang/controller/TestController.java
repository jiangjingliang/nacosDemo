package com.jiang.controller;

import com.jiang.config.PersonPojo;
import com.jiang.dto.TestDto;
import com.jiang.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
@RefreshScope
@Api(tags = "消费模块")
@Configuration
public class TestController {

  /*  @Value("${user.age}")
    private String names;*/
    @Resource
    private PersonPojo personPojo;

    @Resource
    private TestService testService;

    @ApiOperation("测试接口")
    @PostMapping("/testDemo")
    public Object testDemo(@RequestBody TestDto dto){
        System.out.println("============="+personPojo.getName()+personPojo.getAge());
        return testService.testDemo(dto);
    }



}
