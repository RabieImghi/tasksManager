package org.example.taskmanager.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.errors.UserAlreadyExistException;
import org.example.taskmanager.errors.UserEqualsNullException;
import org.example.taskmanager.errors.UserNotExistException;
import org.example.taskmanager.errors.UserPasswordInvalidException;
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
    public Optional<User> register(User user){
        if (user == null) throw new UserEqualsNullException();
        this.findByUsername(user).ifPresent(user2 -> {
            throw new UserAlreadyExistException("Username "+user.getUsername());
        });
        return userRepository.save(user);
    }
    public Optional<User> login(String username, String password) throws Exception{
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            if (BCrypt.checkpw(password,user.get().getPassword())){
                return user;
            }else {
                throw new UserPasswordInvalidException();
            }
        }
        throw new UserNotExistException(username);
    }
    public Optional<User> getById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return user;
        else throw new  UserNotExistException("Null");
    }
    public Optional<User> findByUsername(User user){
        return  userRepository.findByUsername(user.getUsername());
    }
    public Optional<User> deleteById(User user){
        if (user == null) throw new UserEqualsNullException();
        if(this.getById(user.getId()).isPresent()){
            return userRepository.deleteById(user);
        }else throw new UserNotExistException(user.getUsername());
    }
    public Optional<User> update(User user){
        if (user == null) throw new UserEqualsNullException();
        if(this.getById(user.getId()).isEmpty()) throw new UserNotExistException(user.getUsername());
        return userRepository.update(user);
    }
    public List<User> getAll(){
        return userRepository.getAll();
    }

}
