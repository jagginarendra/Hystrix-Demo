package com.demo.hystrix.hystrix;

import com.demo.hystrix.model.AirSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class HystrixExecutorUtil {

    private final HystrixConfigurationFactory hystrixConfigurationFactory;

    private static final Logger logger = Logger.getLogger(HystrixExecutorUtil.class.getName());

    @Autowired
    public HystrixExecutorUtil(HystrixConfigurationFactory hystrixConfigurationFactory) {
        this.hystrixConfigurationFactory = hystrixConfigurationFactory;
    }


    public <T> T execute(java.util.function.Supplier<T> function, AirSupplier supplier, String apiName) {
        final HystrixConfiguration configuration = hystrixConfigurationFactory.getConfiguration(apiName, supplier);
        HystrixCallableCommand<T> command = new HystrixCallableCommand<T>(configuration, () -> executeInternal(function, supplier, apiName));
        if (command.isCircuitBreakerOpen()) {
            logger.log(Level.SEVERE,"Circuit opened for supplier " + supplier + " for apiname " + apiName);
        }
        return command.execute();
    }

    private <T> T executeInternal(Supplier<T> function, AirSupplier supplier, String apiName) {
        try{
            return function.get();
        }catch (Exception e){
            logger.log(Level.SEVERE,"Exception while invoking search");
            throw new RuntimeException(e.getMessage());
        }
    }
}
