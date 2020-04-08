package com.demo.sapient.service;

import com.demo.sapient.exception.NoProductFoundException;
import com.demo.sapient.model.Product;
import com.demo.sapient.model.ProductResponse;
import com.demo.sapient.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductResponse getProductById(String id) {
        Optional<Product> product = productRepository.findById(Integer.parseInt(id));
        if(!product.isPresent()){
            throw new NoProductFoundException("No Product found with id="+id);
        }
        ProductResponse productResponse = new ProductResponse(new ArrayList(){
            {
                add(product.get());
            }
        });
        return productResponse;
    }

    @Override
    public ProductResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            throw new NoProductFoundException("No Products avilaible in system");
        }
        ProductResponse productResponse = new ProductResponse(products);
        return productResponse;
    }

    @Override
    public List<Product> getAllProductsByColor(String color) {
        return null;
    }

    @Override
    public List<Product> getAllProductsBySize(String size) {
        return null;
    }
}
