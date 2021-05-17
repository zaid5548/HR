package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import com.nagarro.dao.UserDao;
import com.nagarro.entities.UserEntity;

@Service
public class LoginService {
    
    @Autowired
    UserDao userdao;
    
    public boolean authenticateUser(String username,String password) {
        
        
        UserEntity user=userdao.getUser(username);
        String encryptedPass=user.getPassword();
        String decryptedPass= getDecodedString(encryptedPass);
        if(user.getUsername().equals(username)&& decryptedPass.equals(username+password)) {
            return true;
        }
        else
            return false;
        
    }

    private String getDecodedString(String password) {
        
        return new String(Base64.getMimeDecoder().decode(password));
    }

}
