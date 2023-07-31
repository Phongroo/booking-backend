package com.example.ecommerce.service;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Customers;
import com.example.ecommerce.model.Products;

import java.util.List;

public interface CustomerService {
    BaseResponse addCustomer(Customers customers);
    BaseResponse updateCustomer(Customers customers);
    BaseResponse getCustomer(Long customerId);
    BaseResponse deleteCustomer(Customers customers);
    public List<Customers> list();
}
