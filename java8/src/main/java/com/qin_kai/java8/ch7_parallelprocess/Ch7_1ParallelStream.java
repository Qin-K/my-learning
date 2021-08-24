package com.qin_kai.java8.ch7_parallelprocess;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * // todo 因为发现实践中基本上不会用到并发流，暂时跳过此章节，后面有需要再回头学习
 * @author qinkai
 * @date 2021/8/23
 */
public class Ch7_1ParallelStream {

    public static void main(String[] args) {
        long n = 100_000_000;
//        System.out.println(sequentialSum(n));
//        System.out.println(iterativeSum(n));
//        System.out.println(parallelStream(n));
//        testPerformance(Ch7_1ParallelStream::sequentialSum, n); 841ms
//        testPerformance(Ch7_1ParallelStream::iterativeSum, n); 35ms
        testPerformance(Ch7_1ParallelStream::parallelStream, n);
    }

    private static long sequentialSum(long n) {
        Long res = Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
        return res;
    }

    private static long iterativeSum(long n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    private static long parallelStream(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    private static void testPerformance(Function<Long, Long> function, long n) {
        long minTimeCost = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            Long result = function.apply(n);
            System.out.println("result:" + result);
            long timeCost = System.currentTimeMillis() - startTime;
            if (timeCost < minTimeCost) {
                minTimeCost = timeCost;
            }
        }
        System.out.println("min time cost for 10 tests is:" + minTimeCost + "ms");
    }
}
