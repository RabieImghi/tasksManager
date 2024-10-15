package org.example.taskmanager.errors;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message){
        super("User with : "+message+" Already Exist Exception");
    }
}
