package com.suprememedia.funda.auth.service;

import com.suprememedia.funda.auth.controller.AuthController;
import com.suprememedia.funda.auth.dto.AuthRequest;
import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.auth.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements  IAuthService{

    @Autowired
    private UserProfileRepository  repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Override
    public UserProfile addUser(UserProfile userProfile) {
        userProfile.setPassword(passwordEncoder.encode(userProfile.getPassword()));
        return repository.save(userProfile);
    }

    @Override
    public String signIn(AuthRequest authRequest) {
        return jwtService.generateToken(authRequest.userName()) ;
    }
}
