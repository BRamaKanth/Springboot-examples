package com.javaavidity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@ApiOperation(value = "Delete Employee Details By Id", notes = "Provide Employee id for details", response = HttpStatus.class)
	public ResponseEntity<HttpStatus> deleteEmpById(@RequestParam(value = "eid") String empid) {
		if (employeeService.deleteEmpByID(empid)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping("emp")
	@ApiOperation(value = "Save new Employee ", notes = "Provide Employee details", response = HttpStatus.class)
	public ResponseEntity<HttpStatus> insertNewEmployee(@RequestBody Employee employee) {
		try {
			if (employeeService.createNewEmployee(employee)) {
				return ResponseEntity.status(HttpStatus.CREATED).build();
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (DuplicateKeyException e) {
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("emp")
	@ApiOperation(value = "Modify the existing Employee ", notes = "Provide Employee details with exisiting id", response = HttpStatus.class)
	public ResponseEntity<HttpStatus> updateEmployee(@RequestBody Employee employee) {
		try {
			if (employeeService.updateEmpDetails(employee)) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
