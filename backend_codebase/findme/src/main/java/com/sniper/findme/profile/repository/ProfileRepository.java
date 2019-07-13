package com.sniper.findme.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sniper.findme.user.model.User;

/**
 * The Interface ProfileRepository.
 */
public interface ProfileRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
