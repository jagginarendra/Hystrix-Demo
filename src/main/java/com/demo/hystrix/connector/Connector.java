package com.demo.hystrix.connector;

import com.demo.hystrix.model.SearchRequest;
import com.demo.hystrix.model.SearchResponse;

public interface Connector {

    SearchResponse search(SearchRequest searchRequest);
}
