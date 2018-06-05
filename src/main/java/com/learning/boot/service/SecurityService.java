package com.learning.boot.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
