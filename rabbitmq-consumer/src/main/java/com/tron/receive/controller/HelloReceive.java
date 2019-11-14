package com.tron.receive.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @auther tron
 * @create 2019-11-08
 */
@Component
public class HelloReceive {

    @RabbitListener(queues = "queue")
    public void process(String string) {
        System.out.println(string);
    }

    //订阅模式

    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }
    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }

    //广播模式

    @RabbitListener(queues="fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:"+str1);
    }
    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }
    @RabbitListener(queues="fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:"+str);
    }
}
