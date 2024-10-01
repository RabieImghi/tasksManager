package org.example.taskmanager.service.impl;

import org.example.taskmanager.entity.User;

import java.util.Optional;

public interface UserServiceImpl {
    boolean register(User user) throws Exception;
    Optional<User> login(String username, String password) throws Exception;
}
