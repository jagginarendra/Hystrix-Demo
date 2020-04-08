package com.demo.hystrix.autowiring.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IsolecesTriangle implements TriangleService {

    private static final Logger logger = LoggerFactory.getLogger(IsolecesTriangle.class);

    public IsolecesTriangle(){
        logger.error("IsolecesTriangle created");
    }


    @Override
    public String draw() {
        return "isoleces triangle";
    }
}
