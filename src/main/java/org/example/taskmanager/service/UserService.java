package org.example.taskmanager.service;

import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.impl.UserServiceImpl;

import java.util.Optional;

public class UserService implements UserServiceImpl {
    private UserRepository userRepository;
    public UserService() {
        this.userRepository = new UserRepository();
    }
    public boolean register(User user) throws Exception{
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Username, email, and password must not be null");
        }
        return userRepository.save(user);
    }
   public Optional<User> login(String username, String password) throws Exception{
        return Optional.empty();
    }

}
