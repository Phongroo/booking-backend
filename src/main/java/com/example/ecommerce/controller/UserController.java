package com.example.ecommerce.controller;

import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.model.UserRole;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);
	return this.userService.createUser(user,userRoleSet);
    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        return this.userService.getUser(username);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }
    @GetMapping(value = "/list")
    public ResponseEntity<?> users(){
        return ResponseEntity.ok(this.userService.list());
    }
    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable("id") Long id)
    {
        return this.userService.getUserId(id);
    }
}
