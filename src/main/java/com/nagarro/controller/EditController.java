package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.apicaller.ApiCaller;
import com.nagarro.entities.Employee;

@Controller
public class EditController {

	@RequestMapping("/edit")
	public String editEmployee(HttpServletRequest request,@ModelAttribute("employee") Employee employee, Model model) {
		model.addAttribute("employee", employee);
//		System.out.println(employee.toString());
//		System.out.println("Edit .......");
		
		HttpSession httpSession=request.getSession(false);
		if(httpSession==null || httpSession.getAttribute("user")==null) {
			return "login.jsp";
		}else {
			
			return "editEmployeePage.jsp";
		}
		
	}

	@RequestMapping(path = "/editEmployee", method = RequestMethod.POST)
	public ModelAndView editEmployeeTask(@RequestParam("emp_Id") String id, @RequestParam("emp_Code") String emp_Code,
			@RequestParam("emp_Name") String emp_Name, @RequestParam("location") String location,
			@RequestParam("email") String email, @RequestParam("dob") String dob)
			throws JsonGenerationException, JsonMappingException, IOException {

		ModelAndView mv = new ModelAndView();
		Employee employee = new Employee();
		employee.setId(Long.parseLong(id));
		employee.setEmp_Code(Integer.parseInt(emp_Code));
		employee.setEmp_Name(emp_Name);
		employee.setLocation(location);
		employee.setEmail(email);
		employee.setDob(dob);
		int empCode = employee.getEmp_Code();

		ApiCaller apiCaller = new ApiCaller();
		apiCaller.updateEmployee(empCode, employee);
		List<Employee> list = apiCaller.getEmployee();
		mv.addObject("employeeList", list);
		mv.setViewName("employeedetails.jsp");
		return mv;
	}

}
