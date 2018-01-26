package com.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Employee;
import com.spring.service.impl.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeServiceImpl employeeService = ac.getBean(EmployeeServiceImpl.class);
		getEmployeeById(employeeService);

	}

	private static void getEmployeeById(EmployeeServiceImpl employeeService) {
		Employee employee = employeeService.fetchEmployeeById(1);
		System.out.println("Employee record :"+ employee.getSalary()+" "+employee.getEmpName());
		System.out.println("---------------------------------------------------");
	}

}
