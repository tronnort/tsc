package com.tron.web.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * 需要在配置类添加 @EnableAsync
 */
@Service
public class AsyncService {
    @Async
    public String getStr() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("异步方法执行完成");
        return "success";
    }
}
