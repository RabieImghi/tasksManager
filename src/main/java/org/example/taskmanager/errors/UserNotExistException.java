package org.example.taskmanager.errors;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(String name){
        super("User "+name+" Not Exist !");
    }
}
