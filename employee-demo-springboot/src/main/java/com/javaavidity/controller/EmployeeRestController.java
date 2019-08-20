package com.javaavidity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaavidity.model.Employee;
import com.javaavidity.services.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("emp/{eid}")
	@ApiOperation(value = "Find Employee Details By Id", notes = "Provide Employee id for details", response = Employee.class)
	public ResponseEntity<Employee> getEmployeeData(@RequestParam(value = "eid") String empid) {

		Optional<Employee> empData = employeeService.getEmpDataById(empid);
		if (empData.isPresent()) {
			return ResponseEntity.ok(empData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("emp")
	@ApiOperation(value = "Get All EmployeeDetails", notes = "", response = List.class)
	public ResponseEntity<List<Employee>> getAllEmployeeData() {

		List<Employee> getEmpDataList = employeeService.getAllEmpDetails();
		return ResponseEntity.ok(getEmpDataList);
	}

	@DeleteMapping("emp/{eid}")
	@ApiOperation(value = "Delete Employee Details By Id", notes = "Provide Employee id for details", response = Boolean.class)
	public ResponseEntity<HttpStatus> deleteEmpById(@RequestParam(value = "eid") String empid) {
		if(employeeService.deleteEmpByID(empid)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}
