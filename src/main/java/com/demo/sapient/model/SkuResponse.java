package com.demo.sapient.model;

import java.util.List;

public class SkuResponse {


    private List<Sku> skus;

    public SkuResponse(List<Sku> skus) {
        this.skus = skus;
    }

    public List<Sku> getSkus() {
        return skus;
    }
}
