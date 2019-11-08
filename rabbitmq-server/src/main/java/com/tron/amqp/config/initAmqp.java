package com.tron.amqp.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Description
 * @auther tron
 * @create 2019-11-08
 */
public class initAmqp implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        /**
         *
         * 初始化参数根据 队列配置类进行设置
         *
         * */
        amqpTemplate.convertAndSend("queue","init-----queue");
        amqpTemplate.convertAndSend("exchange","topic.message","topic.message加入消息队列");
        amqpTemplate.convertAndSend("exchange","topic.messages","topic.messages加入消息队列");
        amqpTemplate.convertAndSend("fanoutExchange","topic.messages","fanoutExchange加入消息队列");
    }
}
