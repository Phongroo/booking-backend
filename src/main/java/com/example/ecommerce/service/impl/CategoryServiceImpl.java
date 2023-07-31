package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.BaseResponse;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Products;
import com.example.ecommerce.repo.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository repo;
    @Override
    public BaseResponse addCategory(Category category) {
        if(category==null|| category.getName()==null
                ||category.getUrl()==null){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "Tham số bắt buộc không được trống");
        }
        Category create = repo.save(category);

        if (create != null ) {
            return new BaseResponse(category, String.valueOf(HttpStatus.OK.value()), "Tạo mới thành công");
        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Tạo mới thất bại");
    }

    @Override
    public BaseResponse updateCategory(Category category) {
        if(category==null|| category.getName()==null
                ||category.getUrl()==null){
            return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "Tham số bắt buộc không được trống");
        }
        Category create = repo.save(category);

        if (create != null ) {
            return new BaseResponse(category, String.valueOf(HttpStatus.OK.value()), "Cập nhật thành công");
        }

        return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Cập nhật thất bại");
    }

    @Override
    public BaseResponse getCategory(Long categoryId) {
        return new BaseResponse(repo.findById(categoryId), String.valueOf(HttpStatus.OK.value()), "");

    }

    @Override
    public BaseResponse deleteCategory(Category category) {
        this.repo.deleteById(category.getId());
        return new BaseResponse(category, String.valueOf(HttpStatus.OK.value()), "Xoá thành công");

    }

    @Override
    public List<Category> list() {
        return repo.findAll();
    }
}
