package com.ltts.dao;

import java.util.List;
import java.util.Optional;

import com.ltts.model.Employee;

public interface employeeDAO {

	public boolean addemployee(Employee employee);
	public List<Employee> getemployee();
	public Employee findByemployeedid(int employeeid);
	public Optional<Employee> findbyid(int employeeid);
	public int deleteemployee(int employeeid);
}
