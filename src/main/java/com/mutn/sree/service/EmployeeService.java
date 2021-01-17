package com.mutn.sree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutn.sree.bean.Employee;
import com.mutn.sree.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public static List<Employee> list = new ArrayList<Employee>();
	public static int counter = 1;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee obj) {
		return employeeRepository.save(obj);
	}

	public Employee findEmployeeById(String id) {
		return employeeRepository.findEmployeeById(id);
	}

	public Employee updateEmployee(Employee obj) {
		return employeeRepository.update(obj);
	}

	public List<Employee> deleteEmployee(String id) {
		employeeRepository.delete(id);
		return employeeRepository.findAll();
	}

}
