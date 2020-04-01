package com.demo.hystrix.connector.tf;

import com.demo.hystrix.connector.AbstractConnector;
import com.demo.hystrix.model.AirSupplier;
import com.demo.hystrix.model.SearchPromise;
import com.demo.hystrix.model.SearchRequest;
import com.demo.hystrix.model.SearchResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TravelFusionConnector extends AbstractConnector {


    private TravelFusionServiceInvoker travelFusionServiceInvoker;
    private AirSupplier airSupplier;
    private static final Logger logger = Logger.getLogger(TravelFusionConnector.class.getName());

    public TravelFusionConnector(TravelFusionServiceInvoker travelFusionServiceInvoker, AirSupplier airSupplier) {
        super(airSupplier);
        this.travelFusionServiceInvoker = travelFusionServiceInvoker;
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest) {
        logger.log(Level.SEVERE,"TF search called");
        return getSearchResponse(new Random().nextInt(5),searchRequest);
    }

    private SearchResponse getSearchResponse(int index , SearchRequest searchRequest) {
        try{
            Thread.sleep(15000);
        }catch (Exception e){
           e.printStackTrace();
        }
        Random random = new Random();
        List<SearchPromise> promises = new ArrayList<>();
        for(int i = 1 ; i <= index ; i++){
            promises.add(new SearchPromise("P_ID"+i,random.nextInt(3),random.nextInt(15000)));
        }
        return new SearchResponse("doc_"+searchRequest.getAdults(),searchRequest,promises);
    }


}
