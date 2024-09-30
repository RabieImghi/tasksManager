package org.example.taskmanager.repository.impl;

import org.example.taskmanager.entity.User;

import java.util.Optional;

public interface UserRepositoryImpl {
    void save(User user);
    Optional<User> findByEmail(String email);
}
