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
    @Test
    void testRegisterUserNull(){
        assertThrows(UserEqualsNullException.class,()->{
            userService.register(null);
        });
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testRegisterUserSuccess(User user){
        when(userService.findByUsername(user)).thenReturn(Optional.empty());
        when(userRepositoryMock.save(user)).thenReturn(Optional.of(user));
        Optional<User> userOptional = userService.register(user);
        assertTrue(userOptional.isPresent());
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testLoginSuccess(User user) throws Exception {
        when(userRepositoryMock.save(user)).thenReturn(Optional.of(user));
        when(userService.findByUsername(user)).thenReturn(Optional.of(user));
        assertTrue(userService.login(user.getUsername(),"rabie").isPresent());
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testLoginUserWithPasswordInvalid(User user){
        when(userService.findByUsername(user)).thenReturn(Optional.of(user));
        assertThrows(UserPasswordInvalidException.class,()->{
            userService.login(user.getUsername(),"Wrong password");
        });
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testLoginReturnsEmptyWhenUsernameNotFound(User user){
        when(userService.findByUsername(user)).thenReturn(Optional.empty());
        assertThrows(UserNotExistException.class,()-> {
            userService.login("wrong_username",user.getPassword());
        });
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testGetByIdReturnsEmptyWhenUserNotFound(User user){
        user.setId(3L);
        assertThrows(UserNotExistException.class,()->{
            userService.getById(1L);
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


    @Test
    void testUpdateUserWhenUserIsNull(){
        assertThrows(UserEqualsNullException.class, ()->{
            userService.update(null);
        });
    }
    @Test
    void testGetAllUsersIsEmpty(){
        assertTrue(userService.getAll().isEmpty());
    }
    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testUpdateUserSuccess(User user){
        user.setId(1L);
        when(userRepositoryMock.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepositoryMock.update(user)).thenReturn(Optional.of(user));
        assertTrue(userService.update(user).isPresent());
    }
    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testGetByIdSuccess(User user){
        user.setId(1L);
        when(userRepositoryMock.findById(user.getId())).thenReturn(Optional.of(user));
        Optional<User> userOptional = userService.getById(user.getId());
        assertTrue(userOptional.isPresent());
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testFindByUsernameSuccess(User user){
        when(userRepositoryMock.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        Optional<User> userOptional = userService.findByUsername(user);
        assertTrue(userOptional.isPresent());
    }
    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testFindByUsernameReturnsEmptyWhenUserNotFound(User user){
        assertTrue(userService.findByUsername(user).isEmpty());
    }


    @Test
    void testDeleteByIdWhenUserIsNull(){
        assertThrows(UserEqualsNullException.class, ()-> {
            userService.deleteById(null);
        });
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testDeleteByIdWhenUserNotExist(User user){
        user.setId(100L);
        when(userRepositoryMock.findById(user.getId())).thenReturn(Optional.empty());
        assertThrows(UserNotExistException.class,()->{
            userService.deleteById(user);
        });

    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    void testDeleteByIdSuccess(User user){
        user.setId(1L);
        when(userRepositoryMock.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepositoryMock.deleteById(user)).thenReturn(Optional.of(user));
        assertTrue(userService.deleteById(user).isPresent());

    }





}
