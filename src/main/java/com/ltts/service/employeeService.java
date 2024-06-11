package com.ltts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ltts.model.Employee;

@Service
public interface employeeService {
	
	public String addemployee(Employee employee);
	public List<Employee> getemployee();
	public String deleteemployee(int employeeid);
	public String updateemployee(Employee employee);
}
