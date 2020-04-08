package com.demo.hystrix.trip;

import com.demo.hystrix.model.Address;
import com.demo.hystrix.model.Customer;
import com.demo.hystrix.model.Trip;

public class TripServiceImpl implements TripService {

    @Override
    public Trip findTripById(String tripId) {


        return getTrip();
    }


    private Trip getTrip() {

        return new Trip("1000", true, true, false, 25000,
                new Customer("7000", "Narendra", "Jaggi",
                        new Address("345000", "35 bismi", "kagadassapura", "Karnatka")));

    }
}
