package com.projects.JWTDemo.service;

import com.projects.JWTDemo.dao.UserRepo;
import com.projects.JWTDemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity saveUser(UserEntity user){
        user.setPassword(encodePassword(user.getPassword()));
        return userRepo.save(user);
    }

    public void initRolesAndUser(){
//        Role adminRole=new Role();
//        adminRole.setRoleName("Admin");
//        adminRole.setRoleDescription("Admin role ");
//        roleRepo.save(adminRole);
//
//        Role userRole=new Role();
//        userRole.setRoleName("User");
//        userRole.setRoleDescription("User role");
//        roleRepo.save(userRole);

        UserEntity user=new UserEntity();
        user.setUserName("mounika97");
        user.setFirstName("mounika");
        user.setLastName("Bollineni");
        user.setPassword(encodePassword("Mounika@97"));
//        Set<Role> userRoles=new HashSet<>();
//        userRoles.add(userRole);
//        user.setRoles(userRoles);
        userRepo.save(user);

        UserEntity admin=new UserEntity();
        admin.setUserName("admin123");
        admin.setFirstName("admin");
        admin.setLastName("spring");
        admin.setPassword(encodePassword("password@admin"));
//        Set<Role> adminRoles=new HashSet<>();
//        adminRoles.add(adminRole);
//        admin.setRoles(adminRoles);
        userRepo.save(admin);
    }

    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
