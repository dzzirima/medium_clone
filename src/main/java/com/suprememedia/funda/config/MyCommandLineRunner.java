package com.suprememedia.funda.config;
import com.suprememedia.funda.auth.model.UserProfile;
import com.suprememedia.funda.auth.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void run(String...args) throws Exception {

        UserProfile adminProfile =  new UserProfile();
        adminProfile.setBio("This is the admin bio");
        adminProfile.setUserName("admin");

        userProfileRepository.save(adminProfile);

    }
}