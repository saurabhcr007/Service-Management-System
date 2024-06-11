package com.ltts.dao;

import java.util.List;
import java.util.Optional;

import com.ltts.model.Vendor_Service_Mapping;

public interface VendorServiceMappingDAO {

	public boolean addvendorservicemapping(Vendor_Service_Mapping vendorservicemapping);
	public List<Vendor_Service_Mapping> getvendorservicemapping();
	public Vendor_Service_Mapping findByvendorservicemappingid(int vendorservicemappingid);
	public Optional<Vendor_Service_Mapping> findbyid(int vendorservicemappingid);
	public int deletevendorservicemapping(int vendorservicemappingid);
	
}
