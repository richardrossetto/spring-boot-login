package com.springBoot.login.service;

import com.springBoot.login.model.User;

/**
 * Created by Richard Rossetto on 03/09/19.
 */
public interface UserService {
    User findByUsername(String username);

    void save(User userForm);
}
