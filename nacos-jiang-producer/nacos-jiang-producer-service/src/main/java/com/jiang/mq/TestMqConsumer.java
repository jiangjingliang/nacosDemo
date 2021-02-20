package com.jiang.mq;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiang.dto.TestDto;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@RocketMQMessageListener(topic = "${mq.topics.messageTopic}", consumerGroup = "${mq.consumer.group}")
public class TestMqConsumer implements RocketMQListener<MessageExt> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestMqConsumer.class);

    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void onMessage(MessageExt messageExt) {

        try {
            byte[] bytes = messageExt.getBody();
            String tags = messageExt.getTags();
            TestDto dto = objectMapper.readValue(bytes, TestDto.class);
            LOGGER.info("tags:{},dto:{}",tags, JSONObject.toJSON(dto));
        } catch (IOException e) {
            LOGGER.error("mq Exception。。。。。");
            e.printStackTrace();
        }

    }
}
