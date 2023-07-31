package com.example.ecommerce.controller;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Products;
import com.example.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService service;
    @PostMapping(value = "/createCategory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createCategory(@RequestBody Category payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.addCategory(payload));
    }

    @PostMapping(value = "/updateCategory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateCategory(@RequestBody Category payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.updateCategory(payload));
    }
    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getCategoryById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(service.getCategory(id));
    }
    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteCategory(@RequestBody Category payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteCategory(payload));
    }
    @GetMapping(value = "/")
    public ResponseEntity<?>categories(){
        return ResponseEntity.ok(this.service.list());
    }
}
