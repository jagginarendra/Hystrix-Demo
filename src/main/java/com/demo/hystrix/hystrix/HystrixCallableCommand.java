package com.demo.hystrix.hystrix;

import com.netflix.hystrix.HystrixCommand;

import java.util.Objects;
import java.util.concurrent.Callable;

public class HystrixCallableCommand<T> extends HystrixCommand<T> {


    private final Callable<T> callable;

    protected HystrixCallableCommand(HystrixConfiguration hystrixConfiguration , Callable<T> callable) {
        super(hystrixConfiguration.getSetter());
        Objects.requireNonNull(callable,"Callable cannot be Null");
        this.callable = callable;

    }

    @Override
    protected T run() throws Exception {
        return callable.call();
    }
}
