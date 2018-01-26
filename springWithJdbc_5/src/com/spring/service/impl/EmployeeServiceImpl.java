package com.spring.service.impl;

import java.util.List;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> getAllEmployeeInfo() {
		return employeeDao.getAllEmployeeDetails();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}

	@Override
	public Employee fetchEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		employeeDao.deleteEmployeeById(employeeId);
	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		employeeDao.updateEmployeeEmailById(newEmail, employeeId);
	}

}
