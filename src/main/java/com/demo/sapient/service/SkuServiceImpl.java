package com.demo.sapient.service;

import com.demo.sapient.exception.NoSkuFoundException;
import com.demo.sapient.exception.SkuSaveException;
import com.demo.sapient.model.Sku;
import com.demo.sapient.model.SkuResponse;
import com.demo.sapient.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkuServiceImpl implements SkuService {


    @Autowired
    SkuRepository skuRepository;

    @Override
    public SkuResponse getSkuById(String skuId) {

        Optional<Sku> sku = skuRepository.findById(Integer.parseInt(skuId));
        if(!sku.isPresent()){
            throw new NoSkuFoundException("No Sku found with id "+skuId);
        }
        SkuResponse skuResponse = new SkuResponse(new ArrayList(){
            {
                add(sku.get());
            }
        });
        return skuResponse;
    }

    @Override
    public SkuResponse getAllSku() {
        List<Sku> skus = skuRepository.findAll();
        if(skus.isEmpty()){
            throw new NoSkuFoundException("No Sku present in D/B");
        }
        SkuResponse skuResponse = new SkuResponse(skus);
        return skuResponse;
    }

    @Override
    public SkuResponse saveSku(Sku sku) {

        Sku savedSku = skuRepository.save(sku);
        if(savedSku == null){
            throw new SkuSaveException("Unable to save sku in D/B");
        }
        SkuResponse skuResponse = new SkuResponse(new ArrayList(){
            {
                add(savedSku);
            }
        });
        return skuResponse;
    }

    @Override
    public SkuResponse getAllSkuByColor(String color) {
        List<Sku> skus = skuRepository.findByColor(color);
        if(skus == null || skus.isEmpty()){
            throw new NoSkuFoundException("No Sku found with color "+color);
        }
        return new SkuResponse(skus);
    }

    @Override
    public SkuResponse getAllSkuBySize(int size) {
        List<Sku> skus = skuRepository.findBySize(size);
        if(skus == null || skus.isEmpty()){
            throw new NoSkuFoundException("No Sku found with size "+size);
        }
        return new SkuResponse(skus);
    }
}
