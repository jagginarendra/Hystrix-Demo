package com.demo.hystrix.controller;


import com.demo.hystrix.hystrix.HystrixExecutorUtil;
import com.demo.hystrix.model.SearchRequest;
import com.demo.hystrix.model.SearchResponse;
import com.demo.hystrix.service.FlightSearchService;
import com.demo.hystrix.model.AirSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchWebController {

    @Autowired
    HystrixExecutorUtil hystrixExecutorUtil;

    @Autowired
    FlightSearchService flightSearchService;

    @PostMapping("/v1/flights")
    public SearchResponse doSearch(@RequestParam("supplier") String supplier, @RequestParam("credentialKey") String credentialKey, @RequestBody SearchRequest searchRequest) {
        AirSupplier airSupplier = AirSupplier.valueOf(supplier);
        SearchResponse searchResponse = hystrixExecutorUtil.execute(() -> flightSearchService.search(airSupplier, searchRequest, credentialKey), airSupplier, "SEARCH");
        return searchResponse;

    }

}
