package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import com.nagarro.dao.UserDao;
import com.nagarro.entities.UserEntity;

@Service
public class UserService {
    
    @Autowired
    UserDao userdao;
    
    public void addUser(String username,String password,String name) {
        
        String encryptedPass=getEncodedString(username+password);
        
        UserEntity user=new UserEntity();
        user.setName(name);
        user.setPassword(encryptedPass);
        user.setUsername(username);
        userdao.saveUser(user);
        
    }

    private String getEncodedString(String password) {

        return Base64.getEncoder().encodeToString(password.getBytes());
    }

}
