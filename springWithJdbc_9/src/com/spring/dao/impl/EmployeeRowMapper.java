package com.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNo) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("empId"));
		employee.setEmpName(rs.getString("empName"));
		employee.setEmail(rs.getString("email"));
		employee.setSalary(rs.getDouble("salary"));
		return employee;
	}

}
