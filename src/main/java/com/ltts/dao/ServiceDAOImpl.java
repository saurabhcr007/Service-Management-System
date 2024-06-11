package com.ltts.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.jpa.serviceJPARepoImpl;
import com.ltts.model.Services;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private serviceJPARepoImpl serviceJPA;
	
	@Override
	public boolean addservice(Services service) {
		if(serviceJPA.save(service)!=null)
			return true;
		else
			return false;
	}

	@Override
	public List<Services> getservice() {
		List<Services> temp=(List<Services>)serviceJPA.findAll();
		return temp;
	}

	@Override
	public Services findByserviceid(int serviceid) {
		return serviceJPA.findByserviceid(serviceid);
	}

	@Override
	public Optional<Services> findbyid(int serviceid) {
		return serviceJPA.findById(serviceid);
	}

	@Override
	public int deleteservice(int serviceid) {
		return serviceJPA.deleteByserviceid(serviceid);
	}
	
}
