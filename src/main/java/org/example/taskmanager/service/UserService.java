package org.example.taskmanager.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.impl.UserServiceImpl;

import java.util.Optional;

public class UserService implements UserServiceImpl {

    private UserRepository userRepository;


    public UserService() {
        this.userRepository = new UserRepository();
    }


    public Optional<User> register(User user,  HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        if (user == null) {
            session.setAttribute("emptyUser", "User cannot be null");
        }

        userRepository.findByEmail(user.getEmail()).ifPresentOrElse(user1 -> {
            session.setAttribute("existEmail","Email already exists");
        }, () -> userRepository.findByUsername(user.getUsername()).ifPresentOrElse(user2 -> {
            session.setAttribute("existUsername","Username already exists");
        },()->userRepository.save(user)));
        return Optional.of(user);
    }
    public Optional<User> login(String username, String password) throws Exception{
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)){
                return user;
            }
        }
        return Optional.empty();
    }
    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }
    public Optional<User> deleteById(User user){
        return userRepository.deleteById(user);
    }
    public Optional<User> update(User user){
        return userRepository.update(user);
    }
}
