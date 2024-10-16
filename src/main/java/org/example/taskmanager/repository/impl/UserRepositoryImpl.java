package org.example.taskmanager.repository.impl;

import org.example.taskmanager.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryImpl {
    Optional<User> save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    Optional<User> deleteById(User user);
    Optional<User> update(User user);
    List<User> getAll();
}
