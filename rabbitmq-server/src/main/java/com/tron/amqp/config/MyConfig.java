package com.tron.amqp.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @auther tron
 * @create 2019-11-08
 */
@Configuration
public class MyConfig {


    @Bean
    public initAmqp initAmqp() {
        return new initAmqp();        //配置amqp的初始化监听器
    }


    /**
     *
     * 默认Direct模式相当于一对一模式,一个消息被发送者发送后,会被转发到一个绑定的消息队列中,然后被一个接收者接收!
     *
     * */
    @Bean
    public Queue queue() {
        return new Queue("queue");  //队列的名称为queue
    }

    //--------------------------------------------订阅模式------------------------------------------------

    /**
     *
     * 交换机(Exchange).它使得生产者和消息队列之间产生了隔离,生产者将消息发送给交换机,而交换机则根据调度策略把相应的消息转发给对应的消息队列.
     * 交换机有四种类型,分别为
     * Direct,
     * topic,依据通配符,队列和交换机的绑定主要是依据一种模式(通配符+字符串)
     * headers,
     * Fanout.路由广播的形式,将会把消息发给绑定它的全部队列,即便设置了key,也会被忽略.
     *
     * */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }


    @Bean(name="message")
    public Queue queueMessage() {
        return new Queue("topic.message");  //队列的名称为topic.message
    }

    @Bean(name="messages")
    public Queue queueMessages() {
        return new Queue("topic.messages");  //队列的名称为topic.messages
    }

    @Bean
    public Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message"); //匹配规则
    }

    @Bean
    public Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//匹配规则  *表示一个词,#表示零个或多个词
    }


    //----------------------------------------------广播模式-------------------------------------------

    @Bean(name="Amessage")
    public Queue AMessage() {
        return new Queue("fanout.A");  //队列的名称
    }


    @Bean(name="Bmessage")
    public Queue BMessage() {
        return new Queue("fanout.B");  //队列的名称
    }

    @Bean(name="Cmessage")
    public Queue CMessage() {
        return new Queue("fanout.C");  //队列的名称
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");//配置广播路由器
    }

    @Bean
    public Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(@Qualifier("Bmessage") Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeC(@Qualifier("Cmessage") Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
