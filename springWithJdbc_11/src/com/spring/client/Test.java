package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Employee;
import com.spring.service.impl.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeServiceImpl employeeService = ac.getBean(EmployeeServiceImpl.class);
		createEmployee(employeeService);
		getEmployeeById(employeeService);
		fetchAllEmployeeInfo(employeeService);
		updateEmployeeInfo(employeeService);
		deleteEmployeeById(employeeService);

	}

	private static void deleteEmployeeById(EmployeeServiceImpl employeeService) {
		employeeService.deleteEmployeeById(7);
		System.out.println("---------------------------------------------------");
	}

	private static void updateEmployeeInfo(EmployeeServiceImpl employeeService) {
		employeeService.updateEmployeeEmailById("pk@infosys.com", 27);
		System.out.println("---------------------------------------------------");
	}

	private static void fetchAllEmployeeInfo(EmployeeServiceImpl employeeService) {
		List<Employee> empList = employeeService.getAllEmployeeInfo();
		System.out.println(".....List of Employess.....");
		for (Employee emp : empList) {
			System.out.println("Employee record :" + emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getEmail()
					+ " " + emp.getSalary());
		}
		System.out.println("---------------------------------------------------");
	}

	private static void getEmployeeById(EmployeeServiceImpl employeeService) {
		Employee employee = employeeService.fetchEmployeeById(18);
		System.out.println("Employee record :" + employee.getEmpId() + " " + employee.getEmpName() + " "
				+ employee.getEmail() + " " + employee.getSalary());
		System.out.println("---------------------------------------------------");
	}

	private static void createEmployee(EmployeeServiceImpl employeeService) {
		System.out.println("---------------------------------------------------");
		Employee employee = new Employee();
		employee.setEmpName("nani");
		employee.setEmail("nani@gmail.com");
		employee.setSalary(1250.05);
		employeeService.addEmployee(employee);
		System.out.println("---------------------------------------------------");
	}
}
