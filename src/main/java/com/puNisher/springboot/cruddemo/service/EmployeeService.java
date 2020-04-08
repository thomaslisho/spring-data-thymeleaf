package com.puNisher.springboot.cruddemo.service;

import java.util.List;

import com.puNisher.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAll();
	public Employee findByID(int id);
	public void save(Employee theEmployee);
	public void deleteById(int id);
}
