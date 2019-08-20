package com.javaavidity.services;

import java.util.List;
import java.util.Optional;

import com.javaavidity.model.Employee;

/**
 * @author ramakanth.b
 */
public interface EmployeeService {

	public Optional<Employee> getEmpDataById(String empid);
	public List<Employee> getAllEmpDetails();
}
