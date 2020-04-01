package com.demo.hystrix.hystrix;

import com.demo.hystrix.model.AirSupplier;

public interface HystrixConfigurationFactory {

    HystrixConfiguration getConfiguration(String apiName, AirSupplier supplier);


}
