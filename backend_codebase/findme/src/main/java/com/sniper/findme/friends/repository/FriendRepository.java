package com.sniper.findme.friends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sniper.findme.friends.model.Friend;
import com.sniper.findme.user.model.User;

/**
 * The Interface FriendRepository.
 */
@Repository
public interface FriendRepository extends JpaRepository<Friend, Long>, JpaSpecificationExecutor<User> {

}
