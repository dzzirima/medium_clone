package com.suprememedia.funda.auth.repository;

import com.suprememedia.funda.auth.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository  extends JpaRepository<UserProfile , Long> {
    Optional<UserProfile> findByName(String username);
}
