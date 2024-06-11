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

import com.ltts.model.Service_Used;
import com.ltts.service.ServiceUsedServiceImpl;

@RestController
@RequestMapping("/ServiceUsed")
public class ServiceUsedController {
	
	@Autowired
	private ServiceUsedServiceImpl serviceusedservice;
	
	private static final Logger logger=LoggerFactory.getLogger(ServiceUsedController.class);
	
	@GetMapping("/welcome")
	public String welcome()
	{
		logger.info("Welcome to Service Used Controller");
		return "Welcome to Service Used Controller";
	}
	
	@PostMapping("/add")
	public String addserviceused(@RequestBody Service_Used serviceused) {
		return serviceusedservice.addserviceused(serviceused);
	}
	
	@GetMapping("/get")
	public List<Service_Used> getserviceused(){
		return serviceusedservice.getserviceused();
	}
	
	@PutMapping("/update/{serviceusedid}")
	public String updateserviceused(@PathVariable("serviceusedid")int serviceusedid) {
		return serviceusedservice.updateserviceused(serviceusedid);
	}
	
	@DeleteMapping("/delete/{serviceusedid}")
	public String deleteserviceused(@PathVariable("serviceusedid") int serviceusedid) {
		return serviceusedservice.deleteserviceused(serviceusedid);
	}
}
