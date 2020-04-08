package com.demo.sapient.service;

import com.demo.sapient.model.Product;
import com.demo.sapient.model.ProductResponse;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {

    ProductResponse getProductById(@RequestParam("id") String id);

    ProductResponse getAllProducts();


    List<Product> getAllProductsByColor(@RequestParam("color") String color);


    List<Product> getAllProductsBySize(@RequestParam("size") String size);

}
