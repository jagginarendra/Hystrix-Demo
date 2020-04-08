package com.demo.sapient.service;

import com.demo.sapient.model.Sku;
import com.demo.sapient.model.SkuResponse;

public interface SkuService {

    SkuResponse getSkuById(String skuId);

    SkuResponse getAllSku();

    SkuResponse saveSku(Sku sku);

    SkuResponse getAllSkuByColor(String color);

    SkuResponse getAllSkuBySize(int size);
}
