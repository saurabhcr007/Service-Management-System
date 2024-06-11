package com.ltts.dao;

import java.util.List;
import java.util.Optional;

import com.ltts.model.Service_Used;

public interface serviceusedDAO {

	public boolean addserviceused(Service_Used serviceused);
	public List<Service_Used> getserviceused();
	public Service_Used findByserviceusedid(int serviceusedid);
	public Optional<Service_Used> findbyid(int serviceusedid);
	public int deleteserviceused(int serviceusedid);
	public void updateServiceUsedTimming(int serviceusedid);
	public void totalcostforServiceUsed(int cost,int serviceusedid);
	
}
