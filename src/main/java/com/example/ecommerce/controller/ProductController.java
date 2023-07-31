package com.example.ecommerce.controller;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Products;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    ProductService service;
    @PostMapping(value = "/createProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createProduct(@RequestBody Products payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.addProduct(payload));
    }

    @PostMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateProduct(@RequestBody Products payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(payload));
    }
    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getProductById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(service.getProduct(id));
    }
    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteProduct(@RequestBody Products payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteProduct(payload));
    }
    @GetMapping(value = "/")
    public ResponseEntity<?>products(){
        return ResponseEntity.ok(this.service.list());
    }
}
