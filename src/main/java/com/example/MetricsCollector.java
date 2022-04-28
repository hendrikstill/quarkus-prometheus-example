package com.example;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.runtime.Startup;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Startup
public class MetricsCollector {

    private final MeterRegistry registry;

    private final MyRepository myRepository;

    public MetricsCollector(MeterRegistry registry, MyRepository myRepository) {
        this.registry = registry;
        this.myRepository = myRepository;
        Gauge.builder("my-gauge", myRepository::count).register(registry);
    }
}
