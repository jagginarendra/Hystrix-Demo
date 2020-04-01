package com.demo.hystrix.warmup;

import com.demo.hystrix.model.SearchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class WarmupController {


    @GetMapping("/test")
    public void testWarmup() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 1; i <= 10 ; i++){
            executorService.submit(new MyRunnable(restTemplate));
        }

    }

}


class MyRunnable implements Runnable{

    RestTemplate restTemplate;

    public MyRunnable(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public void run() {
        final String baseUrl = "http://localhost:9080/v1/flights?supplier=TRAVEL_FUSION&credentialKey=production_IN_search_travel_fusion_new1";
        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        SearchRequest searchRequest = new SearchRequest("DEL","BLR","ECONOMY",1,1,1,false);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, searchRequest, String.class);

    }
}
