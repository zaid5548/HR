package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.dao.UserDao;
import com.nagarro.service.UserService;

@Controller
public class SignUpController {
    @Autowired
    UserDao userdao;
    @Autowired
    UserService userService;

    @RequestMapping("/signup")
    public String signup(@RequestParam("name") String name, @RequestParam("username") String username,
            @RequestParam("password") String password) {

        
        userService.addUser(username, password, name);

        return ("login.jsp");
    }

}
