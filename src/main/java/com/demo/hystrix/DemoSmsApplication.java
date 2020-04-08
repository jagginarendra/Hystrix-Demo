package com.demo.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.demo.")
@EnableJpaRepositories("com.demo.sapient.repository")
@EntityScan("com.demo.sapient.model")
public class DemoSmsApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoSmsApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoSmsApplication.class, args);
		/*ShapeService shapeService1 = run.getBeanFactory().getBean("shapeService1", ShapeService.class);
		if(shapeService1 != null){
			logger.error("shapeService1 not null");
		}
		ShapeService shapeService2 = run.getBeanFactory().getBean("shapeService2", ShapeService.class);
		if(shapeService2 != null){
			logger.error("shapeService2 not null");
		}

		DependencyTest dependencyTest = run.getBeanFactory().getBean("dependencyTest", DependencyTest.class);
		dependencyTest.draw();*/
	}

}
