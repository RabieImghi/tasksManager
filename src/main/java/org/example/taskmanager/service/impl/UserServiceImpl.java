package org.example.taskmanager.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.example.taskmanager.entity.User;

import java.util.Optional;

public interface UserServiceImpl {
    Optional<User> register(User user, HttpServletRequest request) throws Exception;
    Optional<User> login(String username, String password) throws Exception;
}
