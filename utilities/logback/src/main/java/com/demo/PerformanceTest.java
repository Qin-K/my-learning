package com.demo;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qinkai
 * @date 2020/12/28
 */
public class PerformanceTest {
    public static final int OP_COUNT = 1000000;

    private static final Logger LOG = LoggerFactory.getLogger("LOG");
    private static final Logger SYNC_LOG = LoggerFactory.getLogger("SYNC_LOG");

    public static final String message = "{\"status\":0,\"code\":0,\"message\":\"成功\",\"encryptType\":0,\"key\":0,\"data\":{\"ifModified\":true,\"md5\":\"4D3FFFADEF972672ACB5E28873CB0149\",\"clientInfo\":\"cfw_9.1.2_ios\",\"interval\":600,\"configInfo\":{\"app\":{\"time\":1604891716677,\"line\":\"nhbgp\",\"data\":{\"server1\":{\"v4\":\"http://appv4.eastmoney.com/server1\",\"v6\":\"http://appv6.eastmoney.com/server1\"},\"server2\":{\"v4\":\"http://appv4.eastmoney.com/server2\",\"v6\":\"http://appv6.eastmoney.com/server2\"}}},\"f10\":{\"time\":1604891716677,\"line\":\"nhbgp\",\"data\":{\"server1\":{\"v4\":\"http://f10v4.eastmoney.com/server1\",\"v6\":\"http://f10v6.eastmoney.com/server1\"},\"server2\":{\"v4\":\"http://f10v4.eastmoney.com/server2\",\"v6\":\"http://f10v6.eastmoney.com/server2\"}}},\"gb\":{\"time\":1604891716677,\"line\":\"nhbgp\",\"data\":{\"server1\":{\"v4\":\"http://gbv4.eastmoney.com/server1\",\"v6\":\"http://gbv6.eastmoney.com/server1\"},\"server2\":{\"v4\":\"http://gbv4.eastmoney.com/server2\",\"v6\":\"http://gbv6.eastmoney.com/server2\"}}},\"news\":{\"time\":1604891716677,\"line\":\"nhbgp\",\"data\":{\"server1\":{\"v4\":\"http://newsv4.eastmoney.com/server1\",\"v6\":\"http://newsv6.eastmoney.com/server1\"},\"server2\":{\"v4\":\"http://newsv4.eastmoney.com/server2\",\"v6\":\"http://newsv6.eastmoney.com/server2\"}}}}}}";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("RollingFileAppender 50 threads:" + test(50, LOG) + "ms");
        System.out.println("AsyncAppender 50 threads:" + test(50, SYNC_LOG) + "ms");
        Thread.sleep(10000);
        System.out.println("RollingFileAppender 100 threads:" + test(100, LOG) + "ms");
        System.out.println("AsyncAppender 100 threads:" + test(100, SYNC_LOG) + "ms");
        Thread.sleep(10000);
        System.out.println("RollingFileAppender 500 threads:" + test(500, LOG) + "ms");
        System.out.println("AsyncAppender 500 threads:" + test(500, SYNC_LOG) + "ms");
        Thread.sleep(10000);
        System.out.println("RollingFileAppender 1000 threads:" + test(1000, LOG) + "ms");
        System.out.println("AsyncAppender 1000 threads:" + test(1000, SYNC_LOG) + "ms");
        Thread.sleep(10000);
        System.out.println("RollingFileAppender 2000 threads:" + test(2000, LOG) + "ms");
        System.out.println("AsyncAppender 2000 threads:" + test(2000, SYNC_LOG) + "ms");
    }

    public static long test(int threadCount, Logger logger) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CountDownLatch countDownLatch = new CountDownLatch(OP_COUNT);
        for (int i = 0; i < OP_COUNT; i++) {
            executorService.submit(() -> {
                logger.info(message);
                countDownLatch.countDown();
            });
        }
        executorService.shutdown();
        countDownLatch.await();
        stopWatch.stop();
        return stopWatch.getTime();
    }
}
