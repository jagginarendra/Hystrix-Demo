package com.demo.sapient.controller;

import com.demo.sapient.model.ProductResponse;
import com.demo.sapient.model.ReasonCode;
import com.demo.sapient.model.Sku;
import com.demo.sapient.model.SkuResponse;
import com.demo.sapient.service.ProductPublishService;
import com.demo.sapient.service.ProductService;
import com.demo.sapient.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductWebController extends AbstractConnector {

    @Autowired
    ProductPublishService productPublishService;

    @Autowired
    ProductService productService;

    @Autowired
    SkuService skuService;

    @GetMapping("/product")
    @Override
    Response<ProductResponse> getProductById(@RequestParam("productId") String id) {
        if (StringUtils.isEmpty(id)) {
            return Response.failure(new Response.Error(ReasonCode.BAD_REQUEST, "No productId provided"));
        }
        ProductResponse productResponse = productService.getProductById(id);
        Response<ProductResponse> success = Response.success(productResponse);
        return success;
    }

    @GetMapping("/products")
    @Override
    Response<ProductResponse> getAllProducts() {
        ProductResponse products = productService.getAllProducts();
        Response<ProductResponse> productResponse = Response.success(products);
        return productResponse;
    }

    @GetMapping("/product/sku/{skuId}")
    @Override
    Response<SkuResponse> getSkuById(@PathVariable String skuId) {
        if (StringUtils.isEmpty(skuId)) {
            return Response.failure(new Response.Error(ReasonCode.BAD_REQUEST, "No Sku Id provided"));
        }
        SkuResponse skuById = skuService.getSkuById(skuId);
        Response<SkuResponse> response = Response.success(skuById);
        return response;
    }


    @GetMapping("/product/skus")
    @Override
    Response<SkuResponse> getAllSku() {
        SkuResponse skuById = skuService.getAllSku();
        Response<SkuResponse> response = Response.success(skuById);
        return response;
    }


    @GetMapping("/product/sku/color/{color}")
    @Override
    Response<SkuResponse> getAllSkuByColor(@PathVariable String color) {

        if(color.trim().length() == 0){
            return Response.failure(new Response.Error(ReasonCode.BAD_REQUEST,"Color value is invalid"));
        }

        SkuResponse skuResponse = skuService.getAllSkuByColor(color);
        Response<SkuResponse> response = Response.success(skuResponse);
        return response;
    }

    @GetMapping("/product/sku/size/{size}")
    @Override
    Response<SkuResponse> getAllSkuBySize(@PathVariable int size) {
        SkuResponse skuResponse = skuService.getAllSkuBySize(size);
        Response<SkuResponse> response = Response.success(skuResponse);
        return response;
    }

    @PostMapping("/product/sku")
    @Override
    Response<SkuResponse> saveSku(@RequestBody  Sku sku) {
        if(isInvalidSku(sku)){
            return Response.failure(new Response.Error(ReasonCode.BAD_REQUEST,"Sku provided is invalid"));
        }
        SkuResponse skuResponse = skuService.saveSku(sku);
        Response<SkuResponse> response = Response.success(skuResponse);
        return response;
    }


}
