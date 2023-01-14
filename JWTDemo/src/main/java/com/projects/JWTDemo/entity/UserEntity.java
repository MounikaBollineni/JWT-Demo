package com.projects.JWTDemo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserEntity {

    @Id
    private String userName;

    private String firstName;

    private String lastName;

    private String password;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "User_ROLE",
//    joinColumns = {
//            @JoinColumn(name = "USER_ID")
//    },
//            inverseJoinColumns = {
//            @JoinColumn(name="ROLE_ID")
//            }
//    )
//    private Set<Role> roles;

    public UserEntity() {
    }

    public UserEntity(String email, String firstName, String lastName, String password) {
        this.userName = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
//        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}
