package com.example.ecommerce.controller;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Customers;
import com.example.ecommerce.model.Products;
import com.example.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @PostMapping(value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createCustomer(@RequestBody Customers payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.addCustomer(payload));
    }

    @PostMapping(value = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateCustomer(@RequestBody Customers payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.updateCustomer(payload));
    }
    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getCustomerById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(service.getCustomer(id));
    }
    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteCustomer(@RequestBody Customers payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteCustomer(payload));
    }
    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>products(){
        return ResponseEntity.ok(this.service.list());
    }
}
