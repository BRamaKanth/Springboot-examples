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
}
