package com.spring.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;

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
