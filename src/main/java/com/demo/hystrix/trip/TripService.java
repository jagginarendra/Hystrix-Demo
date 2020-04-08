package com.demo.hystrix.trip;

import com.demo.hystrix.model.Trip;

public interface TripService {

    Trip findTripById(String tripId);

}
