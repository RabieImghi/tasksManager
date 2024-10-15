package org.example.taskmanager.service;

import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.util.Manage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testRegisterUserAlreadyExistByUsername(){
        User exictUser = new User();
        exictUser.setUsername("rabie");
        User newUser = new User();
        newUser.setUsername("rabie");
        when(userService.findByUsername(newUser)).thenReturn(Optional.of(exictUser));
        Optional<User> result = userService.findByUsername(newUser);
        assertTrue(result.isPresent());
    }

    @Test
    void testRegisterUserAlreadyExistByEmail(){
        User existUser = new User();
        existUser.setEmail("rabie@gmail.com");
        User newUser = new User();
        newUser.setEmail("rabie@gmail.com");
        when(userService.findByEmail(newUser)).thenReturn(Optional.of(existUser));
        Optional<User> user = userService.findByEmail(newUser);
        assertTrue(user.isPresent());
    }


    @Test
    void testRegisterNewUser(){
        User newUser = new User();
        newUser.setUsername("rabieIm");
        newUser.setEmail("rabieIm@gmail.com");
        when(userService.findByUsername(newUser)).thenReturn(Optional.empty());
        when(userService.findByEmail(newUser)).thenReturn(Optional.empty());
        when(userService.save(newUser)).thenReturn(Optional.of(newUser));
        Optional<User> user = userService.save(newUser);
        assertTrue(user.isPresent());
    }

    @Test
    void testLoginUserPasswordInvalid() throws Exception {
       User user = new User("rabie","fr_ra","ls_ra","rabie","rabie@gmail.com", Manage.USER);
       when(userService.save(user)).thenReturn(Optional.of(user));
       when(userService.findByUsername(user)).thenReturn(Optional.of(user));

        Exception exception = assertThrows(Exception.class, () -> {
            userService.login(user.getUsername(), "rabie2");
        });

        assertTrue(exception.getMessage().contains("Wrong password"));
    }
}
