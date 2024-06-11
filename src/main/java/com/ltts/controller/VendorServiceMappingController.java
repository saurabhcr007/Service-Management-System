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

import com.ltts.model.Vendor_Service_Mapping;
import com.ltts.service.VendorServiceMappingServiceImpl;

@RestController
@RequestMapping("/VSM")
public class VendorServiceMappingController {
	
	private static final Logger logger=LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private VendorServiceMappingServiceImpl VSMService;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		logger.info("Welcome to Vendor Service Mapping Controller");
		return "Welcome to Vendor Service Mapping Controller";
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Vendor_Service_Mapping VSM) {
		return VSMService.addvendorservicemapping(VSM);
	}
	
	@GetMapping("/get")
	public List<Vendor_Service_Mapping> getvendorservicemapping() {
		return VSMService.getvendorservicemapping();
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Vendor_Service_Mapping VSM) {
		return VSMService.updatevendorservicemapping(VSM);
	}
	
	@DeleteMapping("/delete/{vendorservicemappingid}")
	public String deletevendorservicemapping(@PathVariable("vendorservicemappingid") int vendorservicemappingid ) {
		return VSMService.deletevendorservicemapping(vendorservicemappingid);
	}

}
