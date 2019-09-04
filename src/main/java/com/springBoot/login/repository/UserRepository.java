package com.springBoot.login.repository;

import com.springBoot.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Richard Rossetto on 03/09/19.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
