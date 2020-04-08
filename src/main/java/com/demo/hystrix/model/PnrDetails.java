package com.demo.hystrix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PnrDetails {

    private String airlinePnr;
    private String gdsPnr;
    private boolean isRoundtrip;


    @JsonCreator
    public PnrDetails(@JsonProperty("airlinePnr")  String airlinePnr,
                      @JsonProperty("gdsPnr")  String gdsPnr,
                      @JsonProperty("isRoundtrip")  boolean isRoundtrip) {
        this.airlinePnr = airlinePnr;
        this.gdsPnr = gdsPnr;
        this.isRoundtrip = isRoundtrip;
    }

    public PnrDetails() {
    }

    @Override
    public String toString() {
        return "PnrDetails{" +
                "airlinePnr='" + airlinePnr + '\'' +
                ", gdsPnr='" + gdsPnr + '\'' +
                ", isRoundtrip=" + isRoundtrip +
                '}';
    }
}
