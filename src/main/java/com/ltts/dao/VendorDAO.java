package com.ltts.dao;

import java.util.List;
import java.util.Optional;

import com.ltts.model.Vendors;

public interface VendorDAO {
	
	public boolean addvendor(Vendors vendor);
	public List<Vendors> getvendor();
	public Vendors findByvendorid(int vendorid);
	public Optional<Vendors> findbyid(int vendorid);
	public int deletevendor(int vendorid);

}
