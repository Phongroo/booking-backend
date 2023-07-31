package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Customers;
import com.example.ecommerce.model.Products;
import com.example.ecommerce.repo.CustomerRepository;
import com.example.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repo;
    @Override
    public BaseResponse addCustomer(Customers customers) {
        if(customers==null|| customers.getFullName()==null
                ||customers.getEmail()==null
                ||customers.getPhoneNumber()==null){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "Tham số bắt buộc không được trống");
        }
        Customers create = repo.save(customers);

        if (create != null ) {
            return new BaseResponse(customers, String.valueOf(HttpStatus.OK.value()), "Tạo mới thành công");
        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tạo mới thất bại");
    }

    @Override
    public BaseResponse updateCustomer(Customers customers) {
        if(customers==null|| customers.getFullName()==null
                ||customers.getEmail()==null
                ||customers.getPhoneNumber()==null){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "Tham số bắt buộc không được trống");
        }
        Customers create = repo.save(customers);

        if (create != null ) {
            return new BaseResponse(customers, String.valueOf(HttpStatus.OK.value()), "Cập nhật thành công");
        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Cập nhật thành công thất bại");
    }

    @Override
    public BaseResponse getCustomer(Long customerId) {
        return new BaseResponse(repo.findById(customerId), String.valueOf(HttpStatus.OK.value()), "");

    }

    @Override
    public BaseResponse deleteCustomer(Customers customers) {
        this.repo.deleteById(customers.getId());
        return new BaseResponse(customers, String.valueOf(HttpStatus.OK.value()), "Xoá thành công");

    }

    @Override
    public List<Customers> list() {

            return repo.findAll();
    }
}
