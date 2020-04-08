package com.demo.hystrix.autowiring.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EquilateralTriangle implements TriangleService {

    private static final Logger logger = LoggerFactory.getLogger(EquilateralTriangle.class);

    public EquilateralTriangle() {
        logger.error("EquilateralTriangle created");
    }

    @Override
    public String draw() {
        return "equilater triangle";
    }
}
