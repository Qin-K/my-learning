package com.qin_kai.springbootscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author qin kai
 * @date 2020/8/28
 */
@Component
public class ScheduleTask1 {

    @Scheduled(fixedRate = 1000) // fixedRate 固定频率执行 单位ms
    public void process() {
        System.out.println("task1 executed current time is " + new Date());
    }
}
