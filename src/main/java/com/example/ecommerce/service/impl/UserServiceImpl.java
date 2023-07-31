package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.User;
import com.example.ecommerce.model.UserRole;
import com.example.ecommerce.repo.RoleRepository;
import com.example.ecommerce.repo.UserRepository;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there");
            throw new Exception("User already present");
        } else {
            for (UserRole ur : userRole) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRole);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User getUserId(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long userId) {

        this.userRepository.deleteById(userId);

    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}