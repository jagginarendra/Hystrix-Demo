package com.demo.sapient.controller;

import com.demo.sapient.exception.NoProductFoundException;
import com.demo.sapient.exception.NoSkuFoundException;
import com.demo.sapient.model.ProductResponse;
import com.demo.sapient.model.ReasonCode;
import com.demo.sapient.model.Sku;
import com.demo.sapient.model.SkuResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class AbstractConnector {


    abstract Response<ProductResponse> getProductById(String id);

    abstract Response<ProductResponse> getAllProducts();

    abstract Response<SkuResponse> getSkuById(String id);

    abstract Response<SkuResponse> getAllSku();

    abstract Response<SkuResponse> getAllSkuByColor(String color);

    abstract Response<SkuResponse> getAllSkuBySize(int size);

    abstract Response<SkuResponse> saveSku(Sku sku);


    boolean isInvalidSku(Sku sku){
        if(sku == null || sku.getInventory() == 0 || sku.getSellerId() <= 0){
            return true;
        }
        return false;
    }


    //exception handlers
    @ExceptionHandler(NoProductFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<?> handleNoProductException(NoProductFoundException e){
            return Response.failure(new Response.Error(ReasonCode.PRODUCT_NOT_FOUND , e.getMessage()));
    }


    @ExceptionHandler(NoSkuFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<?> handleNoProductException(NoSkuFoundException e){
        return Response.failure(new Response.Error(ReasonCode.SKU_NOT_FOUND , e.getMessage()));
    }



}
