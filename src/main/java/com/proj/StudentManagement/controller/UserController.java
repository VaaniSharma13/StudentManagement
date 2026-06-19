package com.proj.StudentManagement.controller;

import com.proj.StudentManagement.entity.User;
import com.proj.StudentManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String register(@Valid @RequestBody User user) {
        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }
}