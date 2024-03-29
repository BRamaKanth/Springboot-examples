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

	public Boolean deleteEmpByID(String empid);

	public Boolean createNewEmployee(Employee emp);

	public Boolean updateEmpDetails(Employee emp);
}
