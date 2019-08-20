package com.javaavidity.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaavidity.dao.EmployeeDao;
import com.javaavidity.model.Employee;
import com.javaavidity.services.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Optional<Employee> getEmpDataById(String empid) {
		return employeeDao.getEmpDataById(empid);
	}

	@Override
	public List<Employee> getAllEmpDetails() {
		return employeeDao.getAllEmpDetails();
	}

	@Override
	public Boolean deleteEmpByID(String empid) {
		return employeeDao.deleteEmpByID(empid);
	}
}
