package com.suprememedia.funda.auth.service;

import com.suprememedia.funda.auth.dto.AuthRequest;
import com.suprememedia.funda.auth.dto.SignInResDto;
import com.suprememedia.funda.auth.model.UserProfile;

public interface IAuthService {

    UserProfile addUser(UserProfile userProfile);

    SignInResDto signIn(AuthRequest authRequest);
}
