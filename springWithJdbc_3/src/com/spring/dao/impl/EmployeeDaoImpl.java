package com.spring.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		String sql = "select * from employee";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		String sql = "select * from employee where empId=?";
		Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), employeeId);
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		String sql = "delete from employee where empId=?";
		int result = jdbcTemplate.update(sql, employeeId);
		if (result > 0) {
			System.out.println("employee record is deleted in database");
		}

	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		String sql = "update employee set email=? where empId=?";
		int result = jdbcTemplate.update(sql, newEmail, employeeId);
		if (result > 0) {
			System.out.println("employee record is updated in database");
		}

	}

	// now we are going to use jdbcTemplate.
	@Override
	public void createEmployee(Employee employee) {
		String sql = "insert into employee(empName,email,salary) values(?,?,?)";
		int result = jdbcTemplate.update(sql,
				new Object[] { employee.getEmpName(), employee.getEmail(), employee.getSalary() });
		if (result > 0) {
			System.out.println("employee record is inserted into database");
		}
	}

}
