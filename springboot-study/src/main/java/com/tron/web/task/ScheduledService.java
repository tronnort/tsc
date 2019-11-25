package com.tron.web.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     *    *     *      *      *      *      *
     *    秒    分     时     日     月     周几
     */
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void print() {
        System.out.println("定时任务执行");
    }

}
