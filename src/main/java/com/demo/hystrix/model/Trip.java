package com.demo.hystrix.model;

public class Trip {

    private String tripId;
    private boolean isAirBooking;
    private boolean isInternational;
    private boolean isRoundtrip;
    private double amount;
    private Customer customer;

    public Trip(String tripId, boolean isAirBooking, boolean isInternational, boolean isRoundtrip, double amount, Customer customer) {
        System.out.println("Trip COns called");
        this.tripId = tripId;
        this.isAirBooking = isAirBooking;
        this.isInternational = isInternational;
        this.isRoundtrip = isRoundtrip;
        this.amount = amount;
        this.customer = customer;
    }



    public String getTripId() {
        System.out.println("getTripId");
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public boolean isAirBooking() {
        System.out.println("getTripId");
        return isAirBooking;
    }

    public void setAirBooking(boolean airBooking) {
        isAirBooking = airBooking;
    }

    public boolean isInternational() {
        System.out.println("get isInternational");
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public boolean isRoundtrip() {
        System.out.println("get isRoundtrip");
        return isRoundtrip;
    }

    public void setRoundtrip(boolean roundtrip) {
        isRoundtrip = roundtrip;
    }

    public double getAmount() {
        System.out.println("getAmount");
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        System.out.println("getCustomer");
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
