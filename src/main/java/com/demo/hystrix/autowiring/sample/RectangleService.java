package com.demo.hystrix.autowiring.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RectangleService {

    private static final Logger logger = LoggerFactory.getLogger(RectangleService.class);

    public RectangleService(){
        logger.error("RectangleService created");
    }
}
