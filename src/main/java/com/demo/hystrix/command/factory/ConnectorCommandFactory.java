package com.demo.hystrix.command.factory;

import com.demo.hystrix.model.SearchRequest;
import com.demo.hystrix.model.SearchResponse;

public interface ConnectorCommandFactory {

    Command<SearchResponse> getSearchCommand(SearchRequest searchRequest , String credential);
}
