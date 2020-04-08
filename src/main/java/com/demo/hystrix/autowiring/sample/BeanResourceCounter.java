package com.demo.hystrix.autowiring.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanResourceCounter implements BeanPostProcessor {

    int counter = 0;

    private static final Logger logger = LoggerFactory.getLogger(BeanResourceCounter.class);

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        logger.error("Total Beans created="+counter++);
        logger.error("Bean created ="+beanName);

        return null;
    }
}
