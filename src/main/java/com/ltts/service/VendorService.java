package com.ltts.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltts.model.Vendors;

@Service
public interface VendorService {

	public String addvendor(Vendors vendor);
	public List<Vendors> getvendor();
	public String updatevendor(Vendors vendor);
	public String deletevendor(int vendorid);
	
}
