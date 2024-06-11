package com.ltts.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ltts.model.Services;
import com.ltts.service.ServiceServiceImpl;

@RestController
@RequestMapping("/Service")
public class ServiceController {
	
	@Autowired
	private ServiceServiceImpl Service;

	private static final Logger logger=LoggerFactory.getLogger(ServiceController.class);
	
	@GetMapping("/welcome")
	public String welcome()
	{
		logger.info("Welcome to Service Controller");
		return "Welcome to Service Controller";
	}
	
	@PostMapping("/add")
	public String addservice(@RequestBody Services serv) {
		return Service.addservice(serv);
	}
	
	@GetMapping("/get")
	public List<Services> getservice() {
		return Service.getservice();
	}
	
	@PutMapping("/update")
	public String updateservice(@RequestBody Services serv) {
		return Service.updateservice(serv);
	}
	
	@DeleteMapping("/delete/{serviceid}")
	public String deleteservice(@PathVariable("serviceid") int serviceid) {
		return Service.deleteservice(serviceid);
	}
	
}
