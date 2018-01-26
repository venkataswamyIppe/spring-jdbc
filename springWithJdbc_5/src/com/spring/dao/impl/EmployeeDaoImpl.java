package com.spring.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployeeDetails() {
		String sql = "select * from employee";
		return getJdbcTemplate().query(sql, new EmployeeRowMapper());
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		String sql = "select * from employee where empId=?";
		Employee employee = getJdbcTemplate().queryForObject(sql, new EmployeeRowMapper(), employeeId);
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		String sql = "delete from employee where empId=?";
		int result = getJdbcTemplate().update(sql, employeeId);
		if (result > 0) {
			System.out.println("employee record is deleted in database");
		}

	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		String sql = "update employee set email=? where empId=?";
		int result = getJdbcTemplate().update(sql, newEmail, employeeId);
		if (result > 0) {
			System.out.println("employee record is updated in database");
		}

	}

	@Override
	public void createEmployee(Employee employee) {
		String sql = "insert into employee(empName,email,salary) values(?,?,?)";
		int result = getJdbcTemplate().update(sql,
				new Object[] { employee.getEmpName(), employee.getEmail(), employee.getSalary() });
		if (result > 0) {
			System.out.println("employee record is inserted into database");
		}
	}

}
