package org.example.taskmanager.service;

import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.impl.UserServiceImpl;

import java.util.Optional;

public class UserService implements UserServiceImpl {
    private UserRepository userRepository;
    public void register(User user) throws Exception{
        userRepository.save(user);
    }
   public Optional<User> login(String username, String password) throws Exception{
        return Optional.empty();
    }

}
