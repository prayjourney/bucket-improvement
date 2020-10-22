package com.zgy.learn.bootmybatisredisactivemqshiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQService {
    @Autowired
    JmsMessagingTemplate template;

    // static Destination destination;

    // 发布订阅的模式
    //    public Destination createTopic(String name) {
    //        // 这块会有点问题
    //        destination = new ActiveMQQueue(name);
    //        return destination;
    //    }

    public String sendMessage(String message){
        template.convertAndSend("testQueue", message);
        return "send okay!";
    }

    //    @JmsListener(destination = "test")
    public String receiveMessage(){
        Message<?> message = template.receive("testQueue");
        return "receive okay!";
    }
}
