package com.demo.hystrix.command.factory;

@FunctionalInterface
public interface Command<T> {

    public T execute();

}
