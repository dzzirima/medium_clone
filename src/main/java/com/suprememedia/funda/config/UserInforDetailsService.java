package com.suprememedia.funda.config;

import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.auth.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInforDetailsService implements UserDetailsService {
    @Autowired
    private UserProfileRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserProfile> userProfile = repository.findByName(username);

       return userProfile.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found "+ username));

    }
}
