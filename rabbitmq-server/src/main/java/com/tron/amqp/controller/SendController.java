package com.tron.amqp.controller;

import com.tron.amqp.sender.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther tron
 * @create 2019-11-08
 */
@RestController
public class SendController {

    @Autowired
    private SendService sendService;

    @GetMapping("/sendMsg")
    public String sendMsg(String msg) {
        sendService.send(msg);
        return "success";
    }

    @GetMapping("/sendMsgWith")
    public String sendMsgWith(String topic, String msg) {
        sendService.sendWith(topic,msg);
        return "success";
    }

    @GetMapping("/sendFanout")
    public String sendFanout(String msg) {
        sendService.sendFanout(msg);
        return "success";
    }
}
