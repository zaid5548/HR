package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.apicaller.ApiCaller;
import com.nagarro.constants.Constant;
import com.nagarro.dao.UserDao;
import com.nagarro.entities.Employee;
import com.nagarro.entities.UserEntity;

@Controller
public class UploadController extends Constant {

	@Autowired
	UserDao userdao;

	@RequestMapping("/upload")
	public String uploadEmployee(HttpServletRequest request, @ModelAttribute("employee") Employee employee,
			Model model) {
		model.addAttribute("employee", employee);
//		System.out.println(employee.toString());
//		System.out.println("Edit .......");

		HttpSession httpSession = request.getSession(false);
		if (httpSession == null || httpSession.getAttribute("user") == null) {
			return "login.jsp";
		} else {

			return "uploademployee.jsp";
		}

	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest request, @RequestParam("emp_Id") String id,
			@RequestParam("emp_Code") String emp_Code, @RequestParam("emp_Name") String emp_Name,
			@RequestParam("location") String location, @RequestParam("email") String email,
			@RequestParam("dob") String dob) throws JsonGenerationException, JsonMappingException, IOException {

		ModelAndView mv = new ModelAndView();
		HttpSession httpSession = request.getSession(false);
		if (httpSession == null || httpSession.getAttribute("user") == null) {
			mv.setViewName("login.jsp");
			return mv;
		} else {

			Employee employee = new Employee();
			employee.setId(Long.parseLong(id));
			employee.setEmp_Code(Integer.parseInt(emp_Code));
			employee.setEmp_Name(emp_Name);
			employee.setLocation(location);
			employee.setEmail(email);
			employee.setDob(dob);
			ApiCaller apiCaller = new ApiCaller();
			apiCaller.addEmployee(employee);
			List<Employee> list = apiCaller.getEmployee();
//				System.out.println("list data of Added : " + list);
			mv.addObject("employeeList", list);
			mv.setViewName("employeedetails.jsp");
			return mv;
		}

	}

}
