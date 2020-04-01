package com.demo.hystrix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchPromise {


    private String promiseId;
    private int numberOfFares;
    private int totalFare;

    @JsonCreator
    public SearchPromise(@JsonProperty("promiseId")String promiseId,
                         @JsonProperty("numberOfFares")int numberOfFares,
                         @JsonProperty("totalFare")int totalFare) {
        this.promiseId = promiseId;
        this.numberOfFares = numberOfFares;
        this.totalFare = totalFare;
    }


    public String getPromiseId() {
        return promiseId;
    }

    public int getNumberOfFares() {
        return numberOfFares;
    }

    public int getTotalFare() {
        return totalFare;
    }
}
