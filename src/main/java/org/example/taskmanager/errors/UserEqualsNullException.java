package org.example.taskmanager.errors;

public class UserEqualsNullException extends RuntimeException {
    public UserEqualsNullException(){
        super("User Is Null");
    }
}

