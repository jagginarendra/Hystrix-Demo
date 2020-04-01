package com.demo.hystrix.command.factory;

import com.demo.hystrix.connector.Connector;
import com.demo.hystrix.model.SearchRequest;
import com.demo.hystrix.model.SearchResponse;

import java.util.function.Function;

public abstract class AbstractConnectorCommandFactory implements ConnectorCommandFactory {


    @Override
    public Command<SearchResponse> getSearchCommand(SearchRequest searchRequest, String credential) {

        return () -> {
            return execute((c) -> {
                final SearchResponse searchResponse = c.search(searchRequest);
                return searchResponse;
            },credential);
        };
    }

    protected <T> T execute(Function<Connector, T> task, String credentials) {
        Connector connector = getConnector(credentials);
        return task.apply(connector);
    }


    public abstract Connector getConnector(String credentials);


}
