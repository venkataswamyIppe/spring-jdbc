package com.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

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
