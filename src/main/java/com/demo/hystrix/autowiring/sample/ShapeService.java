package com.demo.hystrix.autowiring.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class ShapeService /*implements InitializingBean , DisposableBean , BeanNameAware*/ {


    private TriangleService triangleService;
    private RectangleService rectangleService;
    private static final Logger logger = LoggerFactory.getLogger(ShapeService.class);

    public ShapeService(TriangleService triangleService, RectangleService rectangleService) {
        this.triangleService = triangleService;
        this.rectangleService = rectangleService;
        logger.error("ShapeService constructed");
    }


    void draw(){
        logger.error(triangleService.draw());
    }

  /*  @Override
    public void destroy() throws Exception {
        logger.error("Destroy bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.error("After Properties Set");
    }

    @Override
    public void setBeanName(String name) {
        logger.error("SettingBeanName");
    }

    @PostConstruct
    public  void postConstruct(){
        logger.error("PostConstruct");
    }*/
}
