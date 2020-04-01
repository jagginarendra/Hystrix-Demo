package com.demo.hystrix.service;

import com.demo.hystrix.model.SearchRequest;
import com.demo.hystrix.model.SearchResponse;
import com.demo.hystrix.command.factory.ConnectorCommandFactory;
import com.demo.hystrix.model.AirSupplier;

import java.util.Map;

public class FlightSearchServiceImpl implements FlightSearchService {


    private final Map<AirSupplier, ConnectorCommandFactory> connectorCommandFactoryMap;

    public FlightSearchServiceImpl(Map<AirSupplier, ConnectorCommandFactory> connectorCommandFactoryMap) {

        this.connectorCommandFactoryMap = connectorCommandFactoryMap;
    }

    @Override
    public SearchResponse search(AirSupplier airSupplier, SearchRequest request, String credentialID) {

        SearchResponse searchResponse = connectorCommandFactoryMap.get(airSupplier).getSearchCommand(request, credentialID).execute();
        return searchResponse;
    }
}
