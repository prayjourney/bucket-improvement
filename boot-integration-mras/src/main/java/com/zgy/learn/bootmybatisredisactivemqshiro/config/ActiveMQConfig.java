package com.zgy.learn.bootmybatisredisactivemqshiro.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMQConfig {

    @Bean
    public Queue testQueue() {
        return new ActiveMQQueue("testQueue");
    }
    @Bean
    public Topic testTopic() {
        return new ActiveMQTopic("testTopic");
    }
}
