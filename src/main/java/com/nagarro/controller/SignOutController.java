package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignOutController {
    
    @RequestMapping("/signout")
    public ModelAndView signout(HttpServletRequest request) {
        
        ModelAndView mv=new ModelAndView();
        HttpSession session = request.getSession(false);

        session.removeAttribute("user");
        session.invalidate();
        mv.addObject("username", null);
        mv.setViewName("login.jsp");
        return mv;
        
        
    }

}
