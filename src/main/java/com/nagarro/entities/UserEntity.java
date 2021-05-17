package com.nagarro.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {

    private String name;
    @Id
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public UserEntity(String name, String username, String password) {
        super();
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public UserEntity() {

    }

    @Override
    public String toString() {
        return "UserEntity [name=" + name + ", username=" + username + ", password=" + password + "]";
    }

}

