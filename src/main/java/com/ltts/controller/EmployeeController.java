package com.ltts.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltts.model.Employee;
import com.ltts.service.employeeServiceImpl;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private employeeServiceImpl EmployeeService;
	
	@Autowired
	private ObjectMapper mapper;
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/welcome")
	public String welcome()
	{
		logger.info("Welcome to Employee Controller");
		return "Welcome to Employee Controller";
	}
	
//	@PostMapping("/add")
//	public String addemployee(@RequestBody Employee employee) {
//		return EmployeeService.addemployee(employee);
//	}
	
	@PostMapping("/add")
	public String addemployee(
			@RequestParam("image")MultipartFile employeeimage,
			@RequestParam("employee")String employeedata
			) throws IOException {
		Employee employee=null;
		try {
			employee=mapper.readValue(employeedata, Employee.class);
		} 
		 catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		employee.setEmployeeimage(employeeimage.getBytes());
//		System.out.println(employee.toString());
		return EmployeeService.addemployee(employee);
	}
	
	@GetMapping("/get")
	public List<Employee> getemployee() {
		return EmployeeService.getemployee();
	}
	
	@PutMapping("/update")
	public String updateemployee(@RequestBody Employee employee) {
		return EmployeeService.updateemployee(employee);
	}
	
	@DeleteMapping("/delete/{employeeid}")
	public String deleteemployee(@PathVariable("employeeid")int employeeid) {
		return EmployeeService.deleteemployee(employeeid);
	}
}
