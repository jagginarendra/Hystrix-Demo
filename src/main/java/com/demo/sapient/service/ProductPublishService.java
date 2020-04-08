package com.demo.sapient.service;

public interface ProductPublishService {


    boolean addInventoryForProduct(String productId);

    boolean addNewProduct();


    boolean removeProduct();

}
