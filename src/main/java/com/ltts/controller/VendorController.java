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

import com.ltts.model.Vendors;
import com.ltts.service.VendorServiceImpl;

@RestController
@RequestMapping("/Vendor")
public class VendorController {
	
	@Autowired
	private VendorServiceImpl Vendorserv;
	
	private static final Logger logger=LoggerFactory.getLogger(ServiceController.class);

	@GetMapping("/welcome")
	public String welcome()
	{
		logger.info("Welcome to Vendor Controller");
		return "Welcome to Vendor Controller";
	}
	
	@PostMapping("/add")
	public String addvendor(@RequestBody Vendors vendor) {
			return Vendorserv.addvendor(vendor);
		
	}
	
	@GetMapping("/get")
	public List<Vendors> getvendor() {
		return Vendorserv.getvendor();
	}
	
	@PutMapping("/update")
	public String updatevendor(@RequestBody Vendors vendor) {
		return Vendorserv.updatevendor(vendor);
	}
	
	@DeleteMapping("/delete/{vendorid}")
	public String deletevendor(@PathVariable("vendorid") int vendorid) {
		return Vendorserv.deletevendor(vendorid);
	}

}