package com.projects.JWTDemo.dao;

import com.projects.JWTDemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,String> {
}
