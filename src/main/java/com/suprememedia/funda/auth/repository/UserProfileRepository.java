package com.suprememedia.funda.auth.repository;

import com.suprememedia.funda.auth.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository  extends JpaRepository<UserProfile , Long> {
}
