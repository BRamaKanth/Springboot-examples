package com.javaavidity.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.javaavidity.config.BaseDao;
import com.javaavidity.model.Employee;

@Component
public class EmployeeDao extends BaseDao {

	private RowMapper<Employee> employeeRowMapper = BeanPropertyRowMapper.newInstance(Employee.class);

	public Optional<Employee> getEmpDataById(String empid) {
		return this.queryForObject("Select * from employee where empid=?", new Object[] { empid }, Employee.class);

	}

	public List<Employee> getAllEmpDetails() {
		return jdbcTemplate.query("Select * from employee", employeeRowMapper);
	}

	public Boolean deleteEmpByID(String empid) {
		return this.jdbcTemplate.update("delete from employee where empId=?", empid) > 0 ? true : false;
	}

	public Boolean createNewEmployee(Employee emp) {
		return this.jdbcTemplate.update(
				"INSERT INTO employee (empId,name,hireDate,salary) VALUES (?,?,TO_DATE(?, 'yyyy-MM-DD'),?)",
				emp.getEmpId(), emp.getName(), emp.getHireDate(), emp.getSalary()) > 0 ? true : false;
	}

	public Boolean updateEmpDetails(Employee emp) {
		return this.jdbcTemplate.update("update employee set name=? ,hireDate=? ,salary=? where empId=?", emp.getName(),
				emp.getHireDate(), emp.getSalary(), emp.getEmpId()) > 0 ? true : false;
	}
}
