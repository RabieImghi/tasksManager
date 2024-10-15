package org.example.taskmanager.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.example.taskmanager.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceImpl {
    Optional<User> register(User user);
    Optional<User> login(String username, String password) throws Exception;
    Optional<User> getById(Long id);
    Optional<User> deleteById(User user);
    Optional<User> update(User user);
    List<User> getAll();
}
