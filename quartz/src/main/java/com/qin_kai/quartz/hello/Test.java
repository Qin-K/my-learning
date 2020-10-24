package com.qin_kai.quartz.hello;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author qin kai
 * @date 2020/8/24
 */
public class Test {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

//            JobDetail job = JobBuilder.newJob(HelloJob.class)
//                    .withIdentity("job1", "group1")
//                    .build();

            // 使用JobDataMap存储数据
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job2", "group2")
                    .usingJobData("name", "qinkai")
                    .usingJobData("age", 18)
                    .build();
            job.getJobDataMap().put("count", 10);

            // simple trigger
//            Trigger trigger = TriggerBuilder.newTrigger()
//                    .withIdentity("trigger1", "group1")
//                    .startNow()
//                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                            .withIntervalInSeconds(10)
//                            .repeatForever())
//                    .build();

            // cron trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                    .build();

            scheduler.scheduleJob(job, trigger);

            Thread.sleep(30 * 1000);
            scheduler.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
