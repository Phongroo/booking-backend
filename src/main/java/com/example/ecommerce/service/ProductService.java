package com.example.ecommerce.service;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Products;

import java.util.List;
import java.util.Set;

public interface ProductService {
    BaseResponse addProduct(Products products);
    BaseResponse updateProduct(Products products);
    BaseResponse getProduct(Long producId);
    BaseResponse deleteProduct(Products products);
    public List<Products>list();
}
