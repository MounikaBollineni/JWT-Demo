package com.projects.JWTDemo.controller;

import com.projects.JWTDemo.entity.UserEntity;
import com.projects.JWTDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void runInit(){
        userService.initRolesAndUser();
    }
    @PostMapping("/add-user")
    public UserEntity addUser(@RequestBody UserEntity user){
        return userService.saveUser(user);
    }

    @GetMapping("/for-admin")
//    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This is only for admin";
    }

    @GetMapping("/for-user")
//    @PreAuthorize("hasRole('user')")
    public String forUser(){
        return "This is only for user";
    }
}
