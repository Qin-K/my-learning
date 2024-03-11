package com.qin_kai.prometheus;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinkai
 * @date 2024/3/2
 */
@Component
public class TestMetrics implements MeterBinder {

    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public void bindTo(MeterRegistry registry) {
        Counter testCounter = Counter.builder("test.counter")
                .tag("tag", "test")
                .register(meterRegistry);
        testCounter.increment();

        Gauge.builder("test.gauge", Math::random)
                .tag("tag", "test")
                .register(meterRegistry);
    }
}
