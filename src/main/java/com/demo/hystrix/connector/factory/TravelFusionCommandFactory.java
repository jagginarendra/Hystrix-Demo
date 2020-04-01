package com.demo.hystrix.connector.factory;

import com.demo.hystrix.command.factory.AbstractConnectorCommandFactory;
import com.demo.hystrix.connector.Connector;
import com.demo.hystrix.connector.tf.TravelFusionConnector;
import com.demo.hystrix.connector.tf.TravelFusionServiceInvoker;
import com.demo.hystrix.model.AirSupplier;

public class TravelFusionCommandFactory extends AbstractConnectorCommandFactory {


    private TravelFusionServiceInvoker travelFusionServiceInvoker;

    public TravelFusionCommandFactory(TravelFusionServiceInvoker travelFusionServiceInvoker) {
        this.travelFusionServiceInvoker = travelFusionServiceInvoker;
    }

    @Override
    public Connector getConnector(String credentials) {
        return new TravelFusionConnector(travelFusionServiceInvoker, AirSupplier.TRAVEL_FUSION);
    }
}
