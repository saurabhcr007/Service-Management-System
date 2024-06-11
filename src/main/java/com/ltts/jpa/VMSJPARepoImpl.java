package com.ltts.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltts.model.Vendor_Service_Mapping;

@Repository
public interface VMSJPARepoImpl extends CrudRepository<Vendor_Service_Mapping, Integer> {
	
	public Vendor_Service_Mapping findByvendorservicemappingid(int vendorservicemappingid);
	
	public int deleteByvendorservicemappingid(int vendorservicemappingid);
}
