package com.example.ecommerce.service;



import com.example.ecommerce.model.Products;
import com.example.ecommerce.model.User;
import com.example.ecommerce.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRole) throws Exception;
    public User getUser(String username);
    public User getUserId(Long id );
    public void deleteUser(Long userId);
    public List<User> list();



}
