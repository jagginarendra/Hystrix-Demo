package com.demo.hystrix.service;

import com.demo.hystrix.model.SearchRequest;
import com.demo.hystrix.model.SearchResponse;
import com.demo.hystrix.model.AirSupplier;

public interface FlightSearchService {

    SearchResponse search(AirSupplier airSupplier, SearchRequest request, String credentialID);

}
