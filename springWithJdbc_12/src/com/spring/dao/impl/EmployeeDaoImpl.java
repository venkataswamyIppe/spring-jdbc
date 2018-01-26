package com.spring.dao.impl;

import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private SimpleJdbcCall simpleJdbcCall;

	public void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall) {
		this.simpleJdbcCall = simpleJdbcCall;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		simpleJdbcCall.withProcedureName("getEmployeeNameAndSalaryById");
		MapSqlParameterSource inputMap = new MapSqlParameterSource();
		inputMap.addValue("empId", employeeId);
		Map<String, Object> outMap = simpleJdbcCall.execute(inputMap);
		Employee emp = new Employee();
		emp.setSalary((Double) outMap.get("emp_sal"));
		emp.setEmpName((String) outMap.get("emp_name"));
		return emp;
	}

}
