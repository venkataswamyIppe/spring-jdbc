package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeDao {
	public List<Employee>getAllEmployeeDetails();
	public void createEmployee(Employee employee); 
	public Employee getEmployeeById(int employeeId);
	public void deleteEmployeeById(int employeeId);
	public void updateEmployeeEmailById(String newEmail,int employeeId);
	
}
