package com.javaavidity.model;

import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about employee")
public class Employee {

	@ApiModelProperty(notes = "Employee ID")
	private String empId;
	
	@ApiModelProperty(notes = "Employee Name")
    private String name;
	
	@ApiModelProperty(notes = "Employee Date of Joining")
    private Date hireDate;
	
	@ApiModelProperty(notes = "Employee Monthly Salary")
    private Double salary;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
