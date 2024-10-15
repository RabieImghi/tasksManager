package org.example.taskmanager.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Optional;

public class UserService implements UserServiceImpl {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> register(User user,  HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        if (user == null) {
            session.setAttribute("emptyUser", "User cannot be null");
        }

        assert user != null;
        this.findByEmail(user).ifPresentOrElse(user1 -> {
            session.setAttribute("existEmail","Email already exists");
        }, () -> this.findByUsername(user).ifPresentOrElse(user2 -> {
            session.setAttribute("existUsername","Username already exists");
        },()->this.save(user)));
        return Optional.of(user);
    }
    public Optional<User> save(User user){
        return userRepository.save(user);
    }
    public Optional<User> login(String username, String password) throws Exception{
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            if (BCrypt.checkpw(password,user.get().getPassword())){
                return user;
            }else {
                throw new Exception("Wrong password");
            }
        }
        return Optional.empty();
    }
    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }
    public Optional<User> findByUsername(User user){
        return  userRepository.findByUsername(user.getUsername());
    }
    public Optional<User> findByEmail(User user){
        return  userRepository.findByEmail(user.getEmail());
    }
    public Optional<User> deleteById(User user){
        return userRepository.deleteById(user);
    }
    public Optional<User> update(User user){
        return userRepository.update(user);
    }
    public List<User> getAll(){
        return userRepository.getAll();
    }

}
