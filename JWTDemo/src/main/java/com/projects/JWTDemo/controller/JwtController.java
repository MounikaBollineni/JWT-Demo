package com.projects.JWTDemo.controller;

import com.projects.JWTDemo.entity.JwtRequest;
import com.projects.JWTDemo.entity.JwtResponse;
import com.projects.JWTDemo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService service;

    @PostMapping("/generate-token")
    public JwtResponse createToken(@RequestBody JwtRequest request) throws Exception {
        return service.createToken(request);
    }
}
