package com.demo.hystrix.hystrix;

import com.netflix.hystrix.*;

public class HystrixConfiguration {

    private final HystrixCommand.Setter setter;
    private final String commandName;
    private final String groupName;
    private boolean circuitBreakerEnabled;
    private final int requestVolumeThreshold;
    private final int sleepWindowMilliSeconds;
    private final int errorThresholdPercentage;
    private final int concurrency;
    private final HystrixCommandProperties.ExecutionIsolationStrategy isolationStragegy;
    private final int statisticalWindowInMilliseconds;


    public HystrixConfiguration(String commandName, String groupName, boolean circuitBreakerEnabled, int requestVolumeThreshold, int sleepWindowMilliSeconds, int errorThresholdPercentage, int concurrency, HystrixCommandProperties.ExecutionIsolationStrategy isolationStragegy, int statisticalWindowInMilliseconds) {
        this.circuitBreakerEnabled = circuitBreakerEnabled;
        this.requestVolumeThreshold = requestVolumeThreshold;
        this.sleepWindowMilliSeconds = sleepWindowMilliSeconds;
        this.errorThresholdPercentage = errorThresholdPercentage;
        this.statisticalWindowInMilliseconds = statisticalWindowInMilliseconds;
        this.concurrency = concurrency;
        this.isolationStragegy = isolationStragegy;
        this.commandName = commandName;
        this.groupName = groupName;
        HystrixCommand.Setter tempSetter = null;
        if(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD == isolationStragegy) {
            tempSetter = HystrixCommand.Setter
                    .withGroupKey(HystrixCommandGroupKey.Factory.asKey(commandName))
                    .andCommandKey(HystrixCommandKey.Factory.asKey(groupName))
                    .andThreadPoolPropertiesDefaults(
                            HystrixThreadPoolProperties.Setter().withCoreSize(concurrency).withMaximumSize(concurrency)
                    )
                    .andCommandPropertiesDefaults(
                            HystrixCommandProperties.Setter()
                                    .withCircuitBreakerEnabled(circuitBreakerEnabled)
                                    .withExecutionIsolationStrategy(isolationStragegy)
                                    .withExecutionTimeoutEnabled(false)
                                    .withCircuitBreakerRequestVolumeThreshold(requestVolumeThreshold)
                                    .withCircuitBreakerErrorThresholdPercentage(errorThresholdPercentage)
                                    .withCircuitBreakerSleepWindowInMilliseconds(sleepWindowMilliSeconds));
        } else {
            tempSetter = HystrixCommand.Setter
                    .withGroupKey(HystrixCommandGroupKey.Factory.asKey(commandName))
                    .andCommandKey(HystrixCommandKey.Factory.asKey(groupName))
                    .andCommandPropertiesDefaults(
                            HystrixCommandProperties.Setter()
                                    .withCircuitBreakerEnabled(circuitBreakerEnabled)
                                    .withExecutionIsolationStrategy(isolationStragegy)
                                    .withExecutionTimeoutEnabled(false)
                                    .withCircuitBreakerRequestVolumeThreshold(requestVolumeThreshold)
                                    .withCircuitBreakerErrorThresholdPercentage(errorThresholdPercentage)
                                    .withCircuitBreakerSleepWindowInMilliseconds(sleepWindowMilliSeconds)
                                    .withExecutionIsolationSemaphoreMaxConcurrentRequests(concurrency)
                                    .withMetricsRollingStatisticalWindowInMilliseconds(statisticalWindowInMilliseconds));
        }
        this.setter = tempSetter;
    }

    public HystrixCommand.Setter getSetter() {
        return this.setter;
    }
}
