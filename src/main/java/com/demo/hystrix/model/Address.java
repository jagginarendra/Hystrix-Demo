package com.demo.hystrix.model;

public class Address {


    private String addressId;
    private String buildingName;
    private String area;
    private String state;

    public Address(String addressId, String buildingName, String area, String state) {
        this.addressId = addressId;
        this.buildingName = buildingName;
        this.area = area;
        this.state = state;
    }


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getArea() {
        System.out.println("get Area");
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getState() {
        System.out.println("get State");
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
