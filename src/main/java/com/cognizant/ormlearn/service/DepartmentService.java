package com.cognizant.ormlearn.service;

import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Department;

@Transactional
public interface DepartmentService {

	public Department get(int id);
	
	public void save(Department department);
}