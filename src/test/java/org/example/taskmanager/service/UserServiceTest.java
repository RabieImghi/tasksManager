package org.example.taskmanager.service;

import org.example.taskmanager.entity.User;
import org.example.taskmanager.errors.UserAlreadyExistException;
import org.example.taskmanager.errors.UserEqualsNullException;
import org.example.taskmanager.errors.UserNotExistException;
import org.example.taskmanager.errors.UserPasswordInvalidException;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.util.Manage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.stream.Stream;

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
    static Stream<User> userGenerateOld() {
        return Stream.of(
                new User("rabie", "fr_ra", "ls_ra", "rabie", "rabie@gmail.com", Manage.USER)
        );
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testRegisterNewUserByUsernameAlreadyExist(User user){
        when(userService.findByUsername(user)).thenReturn(Optional.of(user));
        assertThrows(UserAlreadyExistException.class,()->{
           userService.register(user);
        });
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testLoginUserPasswordValid(User user){
        when(userService.findByUsername(user)).thenReturn(Optional.of(user));
        assertThrows(UserPasswordInvalidException.class,()->{
            userService.login(user.getUsername(),"Wrong password");
        });
    }

    @Test
    void testRegisterUserNull(){
        assertThrows(UserEqualsNullException.class,()->{
            userService.register(null);
        });
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testDeleteUserNotExist(User user){
        assertThrows(UserNotExistException.class,()->{
            user.setId(100L);
            userService.deleteById(user);
        });
    }

}
