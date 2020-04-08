package com.demo.hystrix.trip;

import com.demo.hystrix.autowiring.sample.ComponentBean;
import com.demo.hystrix.autowiring.sample.ComponentDemo;
import com.demo.hystrix.model.Trip;
import com.demo.hystrix.model.TripRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripWebController {



    @Autowired
    TripService tripService;

    @Autowired
    ComponentDemo demo;

    @Autowired
    ComponentBean componentBean;

    private static final Logger logger = LoggerFactory.getLogger(TripWebController.class);

    @GetMapping("/trip")
    public Trip getTripDetails(@RequestParam("tripId") String tripId) {


        return tripService.findTripById(tripId);
    }

    @PostMapping("/trip/save")
    public Trip getTripDetailsPost(@RequestBody final TripRequest tripRequest) {

        logger.error("Working*****"+tripRequest.toString());
        demo.hello();
        componentBean.hello();

        return tripService.findTripById("1222");
    }


}
