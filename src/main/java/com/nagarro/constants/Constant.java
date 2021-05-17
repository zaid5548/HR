package com.nagarro.constants;

public class Constant {

	public static String GET_ALL_EMP = "http://localhost:8484/employee/";
	public static String ADD_EMP = "http://localhost:8484/employee/";
	public static String EDIT_EMP="http://localhost:8484/employee/";
	public static String APPLICATION_TYPE = "application/json";
	
	
	public static final String DOWNLOAD_TASK="/download";
	public static final String[] CSV_HEADER= {"id","emp_Code","emp_Name","location","email","dob"};
	public static final String CONTENT_TYPE="text/csv";
	public static final String CONTENT_DEPOSITION="Content-Disposition";
	public static final String ATTACHMENT="attachment; filename=employeesInfo.csv";
}
