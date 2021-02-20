package com.jiang.service.impl;

import com.jiang.dto.TestDto;
import com.jiang.service.TestService;
import com.jiang.test.TestFeign;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestFeign testFeign;

    //  topic
    @Value("${mq.topics.messageTopic}")
    private String messageTopic;

    @Resource
    private RocketMQTemplate rocketMqTemplate;

    @Override
    public String testDemo(TestDto dto) {

        StringBuilder sb = new StringBuilder(messageTopic);
        sb.append(":").append("00");
        // 推消息
        rocketMqTemplate.convertAndSend(sb.toString(),dto);


        // testFeign.test(dto.getName())
        return "";
    }
}
