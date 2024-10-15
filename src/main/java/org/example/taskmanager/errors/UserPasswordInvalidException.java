package org.example.taskmanager.errors;

public class UserPasswordInvalidException extends RuntimeException{
    public UserPasswordInvalidException(){
        super("User Password Invalid !!");
    }
}
