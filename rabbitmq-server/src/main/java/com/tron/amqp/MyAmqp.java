package com.tron.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @auther tron
 * @create 2019-11-08
 */
@SpringCloudApplication
public class MyAmqp {


    public static void main(String[] args) {
        SpringApplication.run(MyAmqp.class, args);
        System.out.println("-----容器加载完成时需要确保amqp服务创建的队列被加载进rabbitmq,否则消费者启动时将报错,详情参见config包下的initAmqp-----");
    }

}
