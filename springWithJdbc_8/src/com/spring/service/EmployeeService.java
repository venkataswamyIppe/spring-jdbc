package com.spring.service;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeService {
	public List<Employee>getAllEmployeeInfo();
	public void addEmployee(Employee employee); 
	public Employee fetchEmployeeById(int employeeId);
	public void deleteEmployeeById(int employeeId);
	public void updateEmployeeEmailById(String newEmail,int employeeId);
}
