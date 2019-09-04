package com.springBoot.login.service;

/**
 * Created by Richard Rossetto on 03/09/19.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
