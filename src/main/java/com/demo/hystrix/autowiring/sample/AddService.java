package com.demo.hystrix.autowiring.sample;

@FunctionalInterface
public interface AddService {


    int add(int a, int b , int c);
}
