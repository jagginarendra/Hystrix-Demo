package com.demo.hystrix.autowiring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DependencyTest {

    @Autowired
    @Qualifier("shapeService2")
    private ShapeService myShapeService;


    public void draw() {
        myShapeService.draw();

        AddService addService = (a,b,c) -> {
            return a+b+c;
        };

        int add = addService.add(10, 20, 20);

    }

}
