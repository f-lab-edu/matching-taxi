package com.flab.matchingtaxi.service.redis;

import com.flab.matchingtaxi.model.RemoteMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RemoteMessagePublisher {

    @Autowired
    private RedisTemplate redisTemplate;

    public void publish(ChannelTopic topic, RemoteMessage message){
        redisTemplate.convertAndSend(topic.getTopic(), message);
        log.info("publish message : " + message.toString());
    }
}