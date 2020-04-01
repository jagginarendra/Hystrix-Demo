package com.demo.hystrix.connector;

import com.demo.hystrix.model.AirSupplier;

public abstract class AbstractConnector implements Connector {


    AirSupplier airSupplier;

    public AbstractConnector(AirSupplier airSupplier) {
        this.airSupplier = airSupplier;
    }

}
