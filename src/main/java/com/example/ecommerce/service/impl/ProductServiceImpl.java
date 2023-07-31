package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Products;
import com.example.ecommerce.repo.ProductRepository;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repo;

    @Override
    public BaseResponse addProduct(Products products) {
        if(products==null|| products.getName()==null
                ||products.getDesccription()==null){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "Tham số bắt buộc không được trống");
        }
        Products create = repo.save(products);

        if (create != null ) {
            return new BaseResponse(products, String.valueOf(HttpStatus.OK.value()), "Tạo mới thành công");
        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tạo mới thất bại");
    }

    @Override
    public BaseResponse updateProduct(Products products) {
        if(products==null|| products.getName()==null
                ||products.getDesccription()==null){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "Tham số bắt buộc không được trống");
        }
        Products create = repo.save(products);

        if (create != null ) {
            return new BaseResponse(products, String.valueOf(HttpStatus.OK.value()), "Cập nhật thành công");
        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Cập nhật thất bại");
    }

    @Override
    public BaseResponse getProduct(Long producId) {
        return new BaseResponse(repo.findById(producId), String.valueOf(HttpStatus.OK.value()), "");

    }

    @Override
    public BaseResponse deleteProduct(Products products) {
       this.repo.deleteById(products.getId());
            return new BaseResponse(products, String.valueOf(HttpStatus.OK.value()), "Xoá thành công");

    }

    @Override
    public List<Products> list() {
        return repo.findAll();
    }
}
