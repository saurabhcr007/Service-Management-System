package com.ltts.dao;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.jpa.vendorJPARepoImpl;
import com.ltts.model.Vendors;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public class VendorDAOImpl implements VendorDAO {
	
	@Autowired
	private vendorJPARepoImpl vendorJPA;
	
	@Override
	public boolean addvendor(Vendors vendor) {
		
		
		if(vendorJPA.save(vendor)!=null)
			return true;
		else
			return false;
	}

	@Override
	public List<Vendors> getvendor() {
		List<Vendors> temp=(List<Vendors>)vendorJPA.findAll();
		return temp;
	}


	@Override
	public Vendors findByvendorid(int vendorid) {
		return vendorJPA.findByvendorid(vendorid);
	}
	
	@Override
	public Optional<Vendors> findbyid(int vendorid){
		return vendorJPA.findById(vendorid);
	}
	
	@Override
	public int deletevendor(int vendorid) {
		return vendorJPA.deleteByvendorid(vendorid);
	}
	
}
