package com.ltts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.dao.employeeDAOImpl;
import com.ltts.exception.DataPresentException;
import com.ltts.exception.FieldMissingException;
import com.ltts.exception.NoDataFoundException;
import com.ltts.exception.OperationFailedException;
import com.ltts.model.Employee;

@Service
public class employeeServiceImpl implements employeeService {

	@Autowired
	private employeeDAOImpl EmployeeDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(employeeServiceImpl.class);
	 
	
	@Override
	public String addemployee(Employee employee) {
		if(employee.getEmployeename().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		if(employee.getEmployeeposition().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		if(employee.getEmployeedepartment().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		Optional<Employee> temp=EmployeeDAO.findbyid(employee.getEmployeeid());
		if(temp.isPresent()) {
			logger.warn("Data Present already");
			throw new DataPresentException("Data Present already");
		}
		boolean added=EmployeeDAO.addemployee(employee) ;
		if(added) {
			logger.info("Operation succesfully");
			return "service added successfully";}
		logger.error("Operation failed");
		throw new OperationFailedException("Operation failed");
	}
	
	@Override
	public List<Employee> getemployee(){
		return EmployeeDAO.getemployee();
	}
	
	@Override
	public String updateemployee(Employee employee) {
		Optional<Employee> ispresent=EmployeeDAO.findbyid(employee.getEmployeeid());
		if(ispresent.isPresent()) {
			Employee temp=EmployeeDAO.findByemployeedid(employee.getEmployeeid());
			if(!employee.getEmployeedepartment().isEmpty())
				temp.setEmployeedepartment(employee.getEmployeedepartment());
			if(!employee.getEmployeegrade().isEmpty())
				temp.setEmployeegrade(employee.getEmployeegrade());
			if(!employee.getEmployeeposition().isEmpty())
				temp.setEmployeeposition(employee.getEmployeeposition());
			boolean update=EmployeeDAO.addemployee(temp);
			if(update) {
				logger.info("Operation succesfully");
				return "Update succesfully";}
			logger.error("Operation failed");
			throw new OperationFailedException("Operation failed");
		}
		logger.warn("No data found");
		throw new NoDataFoundException("NO data found");
	}
	
	@Override
	public String deleteemployee(int employeeid){
		Optional<Employee> ispresent=EmployeeDAO.findbyid(employeeid);
		if(ispresent.isPresent()) {
			int temp=EmployeeDAO.deleteemployee(employeeid);
			if(temp>0) {
				logger.info("Operation succesfully");
				return "delete successfully";}
			logger.error("Operation failed");
			throw new OperationFailedException("Operation failed");
		}
		logger.warn("No data found");
		throw new NoDataFoundException("NO data found");
	}
}
