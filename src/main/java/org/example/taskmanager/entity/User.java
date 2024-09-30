package org.example.taskmanager.entity;
import jakarta.persistence.*;
import org.example.taskmanager.util.Manage;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "manage")
    private Manage manage;

    public User() {
    }

    public User(String username,String email, String password, Manage manage) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.manage = manage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Manage getManage() {
        return manage;
    }

    public void setManage(Manage userType) {
        this.manage = userType;
    }
}