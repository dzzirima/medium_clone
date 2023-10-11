package com.suprememedia.funda.auth.controller;


import com.suprememedia.funda.auth.dto.AuthRequest;
import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.auth.repository.UserProfileRepository;
import com.suprememedia.funda.auth.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthServiceImpl service;

    @Autowired
    private PasswordEncoder passwordEncoder;




    @PostMapping("/signup")
    public  UserProfile signUpUser(
            @RequestBody UserProfile userProfile
            ){


       return service.addUser(userProfile);

    }

    @PostMapping("/signin")
    public String authenticateAndGetToken(
            @RequestBody AuthRequest authRequest
            ){

        return  service.signIn(authRequest);

    }
    @GetMapping("/all")
    public  String users(){
        return  "welcome to secure url ";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public  String onlyAdmin(){
        return  "url for the big guys ... admins only ...? ";
    }
}
