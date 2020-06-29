package com.example.demo.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Transient
    private String confirmPass;

    // Constructors
    public User() {
    }

    public User(long id, String username, String password, String email, String confirmPass) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.confirmPass = confirmPass;
    }

    public User(String username, String password, String email, String confirmPass) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.confirmPass = confirmPass;
    }

    public User(User copy) {
        id = copy.id;
        username = copy.username;
        password = copy.password;
        email = copy.email;
        confirmPass = copy.confirmPass;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
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

    public String getConfirmPass() {
        return confirmPass;
    }
    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
}
