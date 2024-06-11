package com.ltts.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.jpa.serviceusedJPARepoImpl;
import com.ltts.model.Service_Used;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class serviceusedImpl implements serviceusedDAO {

	@Autowired
	private  serviceusedJPARepoImpl JPArepo;

	@Override
	public boolean addserviceused(Service_Used serviceused) {
		return JPArepo.save(serviceused) != null;
	}

	@Override
	public List<Service_Used> getserviceused() {
		return (List<Service_Used>) JPArepo.findAll();
	}

	@Override
	public Service_Used findByserviceusedid(int serviceusedid) {
		return JPArepo.findByserviceusedid(serviceusedid);
	}

	@Override
	public Optional<Service_Used> findbyid(int serviceusedid) {
		return JPArepo.findById(serviceusedid);
	}

	@Override
	public int deleteserviceused(int serviceusedid) {
		return JPArepo.deleteByserviceusedid(serviceusedid);
	}
	
	@Override
	public void updateServiceUsedTimming(int serviceusedid) {
		JPArepo.updateServiceUsedTimming(serviceusedid);
	}

	@Override
	public void totalcostforServiceUsed(int cost,int serviceusedid) {
		JPArepo.totalcostforServiceUsed(cost, serviceusedid);
		//JPArepo.currencysetting(serviceusedid);
	}
	
}
