package com.spring.service.impl;

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
	public Employee fetchEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

}
