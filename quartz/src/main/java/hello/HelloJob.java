package hello;

import org.quartz.Job;
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
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOGGER.info("hello.HelloJob is doing, currentTime is " + dateFormat.format(new Date()));
    }
}
