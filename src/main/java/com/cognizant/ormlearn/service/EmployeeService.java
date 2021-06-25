package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Employee;

@Transactional
public interface EmployeeService {

	public Employee get(int id);
	
	public void save(Employee employee);
	
	public List<Employee> getAllPermanentEmployees();
	
	public double getAverageSalary(int id);
	
	public List<Employee> getAllEmployeesNative();
}