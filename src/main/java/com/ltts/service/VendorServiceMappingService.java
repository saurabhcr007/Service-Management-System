package com.ltts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ltts.model.Vendor_Service_Mapping;

@Service
public interface VendorServiceMappingService {
	
	public String addvendorservicemapping(Vendor_Service_Mapping vendorservicemapping);
	public List<Vendor_Service_Mapping> getvendorservicemapping();
	public String updatevendorservicemapping(Vendor_Service_Mapping vendorservicemapping);
	public String deletevendorservicemapping(int vendorservicemappingid);

}
