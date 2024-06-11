package com.ltts.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltts.model.Vendors;

@Repository
public interface vendorJPARepoImpl extends CrudRepository<Vendors, Integer> {

	public Vendors findByvendorid(int vendorid);
	
	public int deleteByvendorid(int vendorid);
	
}
