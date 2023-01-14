package com.projects.JWTDemo.service;

import com.projects.JWTDemo.dao.UserRepo;
import com.projects.JWTDemo.entity.JwtRequest;
import com.projects.JWTDemo.entity.JwtResponse;
import com.projects.JWTDemo.entity.UserEntity;
import com.projects.JWTDemo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createToken(JwtRequest request) throws Exception {
        String userName=request.getUsername();
        String password= request.getPassword();
        authenticate(userName,password);

       final UserDetails userDetails=loadUserByUsername(userName);
       String newToken=jwtUtil.generateToken(userDetails);

       UserEntity user=userRepo.findById(userName).get();
       return new JwtResponse(user,newToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user=userRepo.findById(username).get();

        if(user!=null ){
            return  new User(user.getUserName(),user.getPassword(),new HashSet<>());
        }
        else{
            throw new UsernameNotFoundException("Username is not valid");
        }
    }

//    private Set getAuthorities(UserEntity user){
//        Set authorities =new HashSet();
//        user.getRoles().forEach(role->{authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
//        });
//        return authorities;
//    }

    private void authenticate(String userName,String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        }catch(DisabledException e){
            throw new DisabledException("User is disabled");
        }catch(BadCredentialsException e){
            throw  new BadCredentialsException(("Bad Credentials"));
        }
    }
}
