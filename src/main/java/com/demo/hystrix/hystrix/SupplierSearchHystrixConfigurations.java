package com.demo.hystrix.hystrix;

import com.demo.hystrix.model.AirSupplier;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SupplierSearchHystrixConfigurations implements HystrixConfigurationFactory {


    @Autowired
    Environment environment;


    @Override
    public HystrixConfiguration getConfiguration(String apiNameStr, AirSupplier airSupplier) {
        String supplier = airSupplier.name().toLowerCase();
        String apiName = apiNameStr.toLowerCase();
        String commandName = environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".commandName");

        String groupName = environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".groupName");
        boolean circuitBreakerEnabled = Boolean.parseBoolean(environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".circuitBreakerEnabled"));
        int requestVolumeThreshold = Integer.parseInt(environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".requestVolumeThreshold"));
        int sleepWindowMilliSeconds = Integer.parseInt(environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".sleepWindowMilliSeconds"));
        int errorThresholdPercentage = Integer.parseInt(environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".errorThresholdPercentage"));
        int statisticalWindowInMilliseconds = Integer.parseInt(environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".statisticalWindowInMilliseconds"));
        int concurrency = Integer.parseInt(environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".concurrency"));
        String isolationStrategy = environment.getProperty("ct.air.sms." + supplier + "." + apiName + ".isolationStrategy");
        final HystrixCommandProperties.ExecutionIsolationStrategy executionIsolationStrategy = HystrixCommandProperties.ExecutionIsolationStrategy.valueOf(isolationStrategy.toUpperCase());
        return new HystrixConfiguration(commandName, groupName, circuitBreakerEnabled, requestVolumeThreshold, sleepWindowMilliSeconds, errorThresholdPercentage, concurrency, executionIsolationStrategy, statisticalWindowInMilliseconds);
    }
}
