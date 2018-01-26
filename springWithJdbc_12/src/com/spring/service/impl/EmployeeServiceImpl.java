package com.spring.service.impl;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee fetchEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

}
