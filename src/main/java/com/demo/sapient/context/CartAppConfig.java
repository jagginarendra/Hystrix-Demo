package com.demo.sapient.context;

import com.demo.sapient.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartAppConfig {

    private static final Logger logger = LoggerFactory.getLogger(CartAppConfig.class);

    @Bean
    public ProductService productService() {
        logger.info("Bean created productService");
        return new ProductServiceImpl();
    }

    @Bean
    public ProductPublishService productPublishService() {
        logger.info("Bean created productPublishService");
        return new ProductPublishServiceImpl();
    }

    @Bean
    public SkuService skuService(){
        return new SkuServiceImpl();
    }

}
