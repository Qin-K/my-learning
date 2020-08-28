package com.qin_kai.springbootscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author qin kai
 * @Date 2020/8/28
 */
@Component
public class ScheduleTask {

    @Scheduled(fixedRate = 1000) // fixedRate 固定频率执行 单位ms
    public void process1() {
        System.out.println("process1 executed current time is " + new Date());
    }

    // cron 表达式 秒 分 时 日 月 星期
    // 日和星期不能同时设置，则将不设置那个设置为?
    @Scheduled(cron = "0/10 * * * * ?")
    public void process2() {
        System.out.println("process2 executed current time is " + new Date());
    }
}
