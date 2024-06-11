package com.ltts.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.jpa.VMSJPARepoImpl;
import com.ltts.model.Vendor_Service_Mapping;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public class VendorServiceMappingDAOImpl implements VendorServiceMappingDAO {

	@Autowired
	private VMSJPARepoImpl VSMJPA;
	
	@Override
	public boolean addvendorservicemapping(Vendor_Service_Mapping vendorservicemapping) {
		if(VSMJPA.save(vendorservicemapping)!=null)
			return true;
		else
			return false;
	}

	@Override
	public List<Vendor_Service_Mapping> getvendorservicemapping() {
		List<Vendor_Service_Mapping> temp=(List<Vendor_Service_Mapping>)VSMJPA.findAll();
		return temp;
	}

	@Override
	public Vendor_Service_Mapping findByvendorservicemappingid(int vendorservicemappingid) {
		return VSMJPA.findByvendorservicemappingid(vendorservicemappingid);
	}

	@Override
	public Optional<Vendor_Service_Mapping> findbyid(int vendorservicemappingid) {
		return VSMJPA.findById(vendorservicemappingid);
	}

	@Override
	public int deletevendorservicemapping(int vendorservicemappingid) {
		return VSMJPA.deleteByvendorservicemappingid(vendorservicemappingid);
	}
	
}
