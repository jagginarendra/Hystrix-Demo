package com.demo.hystrix.controller;


import com.demo.hystrix.hystrix.HystrixExecutorUtil;
import com.demo.hystrix.model.SearchRequest;
import com.demo.hystrix.model.SearchResponse;
import com.demo.hystrix.network.NetworkUtilTask;
import com.demo.hystrix.service.FlightSearchService;
import com.demo.hystrix.model.AirSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class SearchWebController {

    @Autowired
    HystrixExecutorUtil hystrixExecutorUtil;

    @Autowired
    FlightSearchService flightSearchService;

    ExecutorService executorService = Executors.newFixedThreadPool(250);

    private static final Logger logger = LoggerFactory.getLogger(SearchWebController.class);

    @PostMapping("/v1/flights")
    public SearchResponse doSearch(@RequestParam("supplier") String supplier, @RequestParam("credentialKey") String credentialKey, @RequestBody SearchRequest searchRequest) {
        AirSupplier airSupplier = AirSupplier.valueOf(supplier);
        SearchResponse searchResponse = hystrixExecutorUtil.execute(() -> flightSearchService.search(airSupplier, searchRequest, credentialKey), airSupplier, "SEARCH");
        return searchResponse;

    }

    @GetMapping("/sync")
    public void doSyncDemo(@RequestParam("latch") int latch,@RequestParam("task") int task){


        CountDownLatch countDownLatch = new CountDownLatch(latch);
        long startTime = System.currentTimeMillis();
        for(int i = 1 ; i<= task ; i++){
                executorService.submit(new NetworkUtilTask(countDownLatch));
        }

        try {
            countDownLatch.await();
            logger.error("latch="+latch+" task="+task);
            logger.error("%%%%%%%%%%%%%COMPLETED%%%%%%%%%%"+((System.currentTimeMillis()-startTime)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
