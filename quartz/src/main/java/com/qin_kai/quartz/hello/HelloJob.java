package com.qin_kai.quartz.hello;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qin kai
 * @Date 2020/8/24
 */
public class HelloJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloJob.class);

    private int count;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOGGER.info("com.qin_kai.quartz.hello.HelloJob is doing, currentTime is " + dateFormat.format(new Date()));

        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String name = jobDataMap.getString("name");
        int age = jobDataMap.getInt("age");
        LOGGER.info("name={}, age={}", name, age);
        LOGGER.info("HelloJob count = {}",  count);
    }

    /**
     * 指定get set 创建job时会自动注入JobDataMap的数据
     */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
