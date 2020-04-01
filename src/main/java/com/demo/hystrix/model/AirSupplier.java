package com.demo.hystrix.model;

public enum AirSupplier {
    INDIGO(1, "indigo"), TRAVEL_FUSION(2, "travel_fusion");

    private int id;
    private String supplier;

    AirSupplier(int id, String supplier) {
        this.id = id;
        this.supplier = supplier;
    }

}
