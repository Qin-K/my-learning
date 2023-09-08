package com.qin_kai.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

/**
 * @author qinkai
 * @date 2023/8/31
 */
public class MyBenchmark {

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.All)
    public void init() {
        // Do nothing
    }

}
