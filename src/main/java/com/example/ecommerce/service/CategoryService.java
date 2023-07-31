package com.example.ecommerce.service;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Products;

import java.util.List;

public interface CategoryService {
    BaseResponse addCategory(Category category);
    BaseResponse updateCategory(Category category);
    BaseResponse getCategory(Long categoryId);
    BaseResponse deleteCategory(Category category);
    public List<Category> list();
}
