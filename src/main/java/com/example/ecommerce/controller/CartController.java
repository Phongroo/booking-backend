package com.example.ecommerce.controller;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartRequest;
import com.example.ecommerce.model.Products;
import com.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService service;
    @PostMapping(value = "/createCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createCart(@RequestBody CartRequest payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.addCart(payload));
    }

    @PostMapping(value = "/updateCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateCart(@RequestBody Cart payload) {

        return ResponseEntity.status(HttpStatus.OK).body(service.updateCart(payload));
    }
    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getCartById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(service.getCart(id));
    }
    @DeleteMapping(value = "/delete/{cardId}")
    public ResponseEntity<BaseResponse> deleteCart(@PathVariable(name = "cardId") Long cardId) {

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteCart(cardId));
    }
    @GetMapping(value = "/")
    public ResponseEntity<?>carts(){
        return ResponseEntity.ok(this.service.list());
    }
}
