package com.demo.hystrix.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SearchRequest {

    private String to;

    private String from;

    private String cabinClass;


    private int adults;

    private int children;

    private int infant;

    private boolean isRoundtrip;

    @JsonCreator
    public SearchRequest(@JsonProperty("to")String to,
                         @JsonProperty("from")String from,
                         @JsonProperty("cabinClass")String cabinClass,
                         @JsonProperty("adults")int adults,
                         @JsonProperty("children")int children,
                         @JsonProperty("infant")int infant,
                         @JsonProperty("isRoundtrip")boolean isRoundtrip) {
        this.to = to;
        this.from = from;
        this.cabinClass = cabinClass;
        this.adults = adults;
        this.children = children;
        this.infant = infant;
        this.isRoundtrip = isRoundtrip;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getInfant() {
        return infant;
    }

    public void setInfant(int infant) {
        this.infant = infant;
    }

    public boolean isRoundtrip() {
        return isRoundtrip;
    }

    public void setRoundtrip(boolean roundtrip) {
        isRoundtrip = roundtrip;
    }
}
