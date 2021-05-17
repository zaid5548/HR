package com.nagarro.apicaller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constants.Constant;
import com.nagarro.entities.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ApiCaller extends Constant {

	private RestTemplate restTemplate = new RestTemplate();

	public List<Employee> getEmployee() throws JsonParseException, JsonMappingException, IOException {

		ResponseEntity<String> entity = restTemplate.getForEntity(GET_ALL_EMP, String.class);

		List<Employee> mainList = null;
		String body = entity.getBody();
		Employee[] emp = new ObjectMapper().readValue(body, Employee[].class);
		mainList = Arrays.asList(emp);
		return mainList;

	}

	public void addEmployee(Employee emp) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(emp);

		Client client = Client.create();
		WebResource webResource = client.resource(ADD_EMP);
		ClientResponse response = webResource.type(APPLICATION_TYPE).post(ClientResponse.class, json);
		response.close();
	}

	// Method to fetch employees by EmployeeCode using REST API
	public void updateEmployee(int emp_Code, Employee employee)
			throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(employee);

		Client client = Client.create();
		WebResource webResource = client.resource(EDIT_EMP + emp_Code);
		ClientResponse response = webResource.type(APPLICATION_TYPE).put(ClientResponse.class, json);
		response.close();

	}

}
