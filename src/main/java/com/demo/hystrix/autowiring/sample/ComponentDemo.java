package com.demo.hystrix.autowiring.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ComponentDemo {

    public void hello() {
        System.out.println("hello");
    }

    @Bean
    public ComponentBean getComponentBean(){
        return new ComponentBean();
    }

}
