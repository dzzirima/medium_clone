package com.suprememedia.funda.config;

//  this  file is used to  convert from user profile to user details object

import com.suprememedia.funda.auth.model.UserProfile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails {
    private String name;

    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoDetails(UserProfile userProfile) {
        name = userProfile.getName();
        password = userProfile.getPassword();
        authorities = Arrays.stream(userProfile.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
