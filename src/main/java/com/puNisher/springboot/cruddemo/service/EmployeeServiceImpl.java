package com.puNisher.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.puNisher.springboot.cruddemo.dao.EmployeeRepository;
import com.puNisher.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeServiceImpl(EmployeeRepository employeeRepository){
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findByID(int id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		if(findById.isPresent())
			return findById.get();
		else
			throw new RuntimeException("\n\nThe Employee with ID "+id+" is not Present\n\n");
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

}
