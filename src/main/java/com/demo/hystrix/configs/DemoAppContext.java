package com.demo.hystrix.configs;

import com.demo.hystrix.autowiring.sample.*;
import com.demo.hystrix.command.factory.ConnectorCommandFactory;
import com.demo.hystrix.connector.factory.TravelFusionCommandFactory;
import com.demo.hystrix.connector.tf.TravelFusionServiceInvoker;
import com.demo.hystrix.model.AirSupplier;
import com.demo.hystrix.service.FlightSearchService;
import com.demo.hystrix.service.FlightSearchServiceImpl;
import com.demo.hystrix.trip.TripService;
import com.demo.hystrix.trip.TripServiceImpl;
import com.netflix.hystrix.contrib.servopublisher.HystrixServoMetricsPublisher;
import com.netflix.hystrix.strategy.HystrixPlugins;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class DemoAppContext {


    private static final Logger logger = Logger.getLogger(DemoAppContext.class.getName());

    static {
        HystrixPlugins.getInstance().registerMetricsPublisher(HystrixServoMetricsPublisher.getInstance());
    }

    @Bean("connectorCommandFactoryMap")
    public Map<AirSupplier, ConnectorCommandFactory> getConnectorCommandFactoryMap() {
        logger.log(Level.SEVERE, "Creating connectorCommandFactoryMap");
        Map<AirSupplier, ConnectorCommandFactory> map = new HashMap<>();
        map.put(AirSupplier.TRAVEL_FUSION, new TravelFusionCommandFactory(new TravelFusionServiceInvoker()));
        return map;
    }

    @Bean
    public FlightSearchService getFlightSearchService(Map<AirSupplier, ConnectorCommandFactory> connectorCommandFactoryMap) {
        logger.log(Level.SEVERE, "Creating FlightSearchService");
        return new FlightSearchServiceImpl(connectorCommandFactoryMap);
    }


    @Bean
    public ShapeService shapeService1(TriangleService equilateralTriangle, RectangleService rectangleService) {
        return new ShapeService(equilateralTriangle, rectangleService);
    }

    @Bean
    public ShapeService shapeService2(TriangleService isolecesTriangle , RectangleService rectangleService) {
        return new ShapeService(isolecesTriangle, rectangleService);
    }


    @Bean
    public TriangleService isolecesTriangle() {
        return new IsolecesTriangle();
    }

    @Bean
    public TriangleService equilateralTriangle() {
        return new EquilateralTriangle();
    }

    @Bean
    public RectangleService rectangleServicessss() {
        return new RectangleService();
    }

    @Bean
    public DependencyTest dependencyTest(){
        return new DependencyTest();
    }


    /*@Bean
    public  BeanResourceCounter beanResourceCounter(){
        return new BeanResourceCounter();
    }
*/

    @Bean
    public TripService tripService(){
        return new TripServiceImpl();
    }

}
