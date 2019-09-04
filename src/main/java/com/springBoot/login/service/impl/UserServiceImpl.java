package com.springBoot.login.service.impl;

import com.springBoot.login.model.User;
import com.springBoot.login.repository.RoleRepository;
import com.springBoot.login.repository.UserRepository;
import com.springBoot.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by Richard Rossetto on 03/09/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
}
