package com.jiang.service.impl;

import com.jiang.dto.TestDto;
import com.jiang.service.TestService;
import com.jiang.test.TestFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestFeign testFeign;

    @Override
    public String testDemo(TestDto dto) {
        return testFeign.test(dto.getName());
    }
}
