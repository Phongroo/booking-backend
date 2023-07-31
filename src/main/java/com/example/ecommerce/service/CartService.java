package com.example.ecommerce.service;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartRequest;
import com.example.ecommerce.model.Products;

import java.util.List;

public interface CartService {
    BaseResponse addCart(CartRequest cartRequest);
    BaseResponse updateCart(Cart cart);
    BaseResponse getCart(Long cartId);
    BaseResponse deleteCart(Long cartId);
    public List<Cart> list();
}
