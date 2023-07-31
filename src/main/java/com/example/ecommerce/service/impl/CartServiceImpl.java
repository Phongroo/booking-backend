package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.*;
import com.example.ecommerce.repo.CartRepository;
import com.example.ecommerce.repo.ProductRepository;
import com.example.ecommerce.repo.UserRepository;
import com.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository repo;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public BaseResponse addCart(CartRequest cartRequest) {
        Products product=productRepository.findById(cartRequest.getProductId()).get();
        User user=userRepository.findById(cartRequest.getUserId()).get();
//        if(cart==null|| cart.getProduct()==null
//                ||cart.getUser()==null){
//            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
//                    "Tham số bắt buộc không được trống");
//        }
        Cart cart=new Cart(product,user);
        Cart create = repo.save(cart);

        if (create != null ) {
            return new BaseResponse(cart, String.valueOf(HttpStatus.OK.value()), "Tạo mới thành công");
        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tạo mới thất bại");
    }

    @Override
    public BaseResponse updateCart(Cart cart) {
        if(cart==null|| cart.getProduct()==null
                ||cart.getUser()==null){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "Tham số bắt buộc không được trống");
        }
        Cart create = repo.save(cart);

        if (create != null ) {
            return new BaseResponse(cart, String.valueOf(HttpStatus.OK.value()), "Tạo mới thành công");
        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tạo mới thất bại");
    }

    @Override
    public BaseResponse getCart(Long cartId) {
        return null;
    }

    @Override
    public BaseResponse deleteCart(Long cartId) {
        this.repo.deleteById(cartId);
        return new BaseResponse("", String.valueOf(HttpStatus.OK.value()), "Xoá thành công");

    }

    @Override
    public List<Cart> list() {
        return repo.findAll();
    }
}
