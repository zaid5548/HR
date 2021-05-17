package com.nagarro.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Employee {

	private long id;

	private int emp_Code;
	private String emp_Name;
	private String location;
	private String email;
	private String dob;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEmp_Code() {
		return emp_Code;
	}

	public void setEmp_Code(int emp_Code) {
		this.emp_Code = emp_Code;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_Code=" + emp_Code + ", emp_Name=" + emp_Name + ", location=" + location
				+ ", email=" + email + ", dob=" + dob + "]";
	}

}
