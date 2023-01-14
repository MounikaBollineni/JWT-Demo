//package com.projects.JWTDemo.controller;
//
//import com.projects.JWTDemo.entity.Role;
//import com.projects.JWTDemo.service.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RoleController {
//    @Autowired
//    private RoleService roleService;
//
//    @PostMapping("/addRole")
//    public Role addRole(@RequestBody Role role){
//       return roleService.saveRole(role);
//    }
//}
