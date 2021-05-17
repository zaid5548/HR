package com.nagarro.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.apicaller.ApiCaller;
import com.nagarro.dao.UserDao;
import com.nagarro.entities.Employee;
import com.nagarro.entities.UserEntity;
import com.nagarro.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	UserDao userdao;

	@Autowired
	LoginService login;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("pass") String password) throws FileNotFoundException {
		ModelAndView mv = new ModelAndView();
		UserEntity user = userdao.getUser(username);
//		mv.addObject("name", user.getName());
		HttpSession httpSession=request.getSession(true);
		HttpSession logoutSession=request.getSession(false);
		
		try {
			if (login.authenticateUser(username, password)) {
//                mv.addObject("username", username);
				System.out.println("Successfully Login...");
//                mv.setViewName("updateemployee.jsp");
				ApiCaller apiCaller = new ApiCaller();
				List<Employee> list = apiCaller.getEmployee();
//				System.out.println("list data" + list);
//				mv.addObject("employeeList",list);
				mv.addObject("employeeList", list);
				
				httpSession.setAttribute("name", user);
				httpSession.setAttribute("userName", user.getName());
				
				mv.setViewName("employeedetails.jsp");
				HttpSession session = request.getSession(true);
				session.setAttribute("user", username);
				return mv;
			}

			mv.setViewName("login.jsp");
			return mv;
		} catch (Exception e) {
			mv.setViewName("login.jsp");
			return mv;
		}

	}

}
