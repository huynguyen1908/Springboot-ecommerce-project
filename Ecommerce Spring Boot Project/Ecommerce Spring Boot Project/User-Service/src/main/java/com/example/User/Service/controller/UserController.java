package com.example.User.Service.controller;

import com.example.User.Service.dto.request.LoginRequest;
import com.example.User.Service.entity.User;
import com.example.User.Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = userService.loginUser(request.getUsername(), request.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        userService.logoutUser();
        return ResponseEntity.ok("Logout successful");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        boolean isDeleted = userService.deletedUser(id);
        if(isDeleted){
            return ResponseEntity.ok("Delete successful");
        }
        return ResponseEntity.status(404).body("User not found");
    }

    @GetMapping("/get-user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
