package com.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		String sql = "select * from employee";
		return namedParameterJdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	// here we can use Map approach or MapSqlParameterSource approach any
	// approach you can follow.
	@Override
	public Employee getEmployeeById(int employeeId) {
		String sql = "select * from employee where empId=:empId";
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("empId", employeeId);
		return namedParameterJdbcTemplate.queryForObject(sql, inputMap, new EmployeeRowMapper());

	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		String sql = "delete from employee where empId=:employeeId";
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("employeeId", employeeId);
		int result = namedParameterJdbcTemplate.update(sql, msps);
		if (result > 0) {
			System.out.println("employee record is deleted in database");
		}

	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		String sql = "update employee set email=:newEmail where empId=:employeeId";
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("newEmail", newEmail);
		msps.addValue("employeeId", employeeId);
		int result = namedParameterJdbcTemplate.update(sql, msps);
		if (result > 0) {
			System.out.println("employee record is updated in database");
		}

	}

	@Override
	public void createEmployee(Employee employee) {
		String sql = "insert into employee(empName,email,salary) values(:empName,:email,:salary)";
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("empName", employee.getEmpName());
		msps.addValue("email", employee.getEmail());
		msps.addValue("salary", employee.getSalary());
		int result = namedParameterJdbcTemplate.update(sql, msps);
		if (result > 0) {
			System.out.println("employee record is inserted into database");
		}

	}

}
