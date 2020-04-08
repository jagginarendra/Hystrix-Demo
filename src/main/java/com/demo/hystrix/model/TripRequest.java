package com.demo.hystrix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TripRequest {

    private String tripId;
    private double amount;
    private PnrDetails pnr;
    private String tripOwner;

    @JsonCreator
    public TripRequest(@JsonProperty("id") String tripId,
                       @JsonProperty("paisey") double amount,
                       @JsonProperty("pnr") PnrDetails pnr,
                       @JsonProperty("owner") String tripOwner) {
        this.tripId = tripId;
        this.amount = amount;
        this.pnr = pnr;
        this.tripOwner = tripOwner;
    }

    public TripRequest() {
        System.out.println("def cons");
    }

    @Override
    public String toString() {
        return "TripRequest{" +
                "tripId='" + tripId + '\'' +
                ", amount=" + amount +
                ", pnr=" + pnr +
                ", tripOwner='" + tripOwner + '\'' +
                '}';
    }
}

